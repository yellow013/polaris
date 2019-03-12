package io.ffreedom.polaris.indicators.pools;

import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.polaris.datetime.TimeTwin;
import io.ffreedom.polaris.datetime.tradingday.impl.TradingDayKeeper;
import io.ffreedom.polaris.financial.Symbol;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;

public final class IndicatorPeriodTimePools {

	private static final IndicatorPeriodTimePools INSTANCE = new IndicatorPeriodTimePools();

	// Map<IndicatorPeriod, Map<Symbol, Set<TimeTwin>>>
	private MutableLongObjectMap<MutableIntObjectMap<ImmutableSet<TimeTwin>>> pools = ECollections
			.newLongObjectHashMap();

	public static void register(Symbol[] symbols, IndicatorPeriod... periods) {
		if (symbols == null)
			throw new IllegalArgumentException("Illegal Argument -> symbols is null");
		if (periods == null)
			throw new IllegalArgumentException("Illegal Argument -> periods in null");
		for (IndicatorPeriod period : periods) {
			INSTANCE.register0(period, symbols);
		}
	}

	private void register0(IndicatorPeriod period, Symbol[] symbols) {
		MutableIntObjectMap<ImmutableSet<TimeTwin>> symbolMap = getSymbolMap(period);
		for (Symbol symbol : symbols)
			findOrCreate(symbolMap, period, symbol);
	}

	/**
	 * 获取当前交易日下指定Symbol和指定指标周期下的全部时间分割点
	 * 
	 * @param period
	 * @param symbol
	 * @return
	 */
	public static ImmutableSet<TimeTwin> getTimeTwinSet(IndicatorPeriod period, Symbol symbol) {
		return INSTANCE.findOrCreate(INSTANCE.getSymbolMap(period), period, symbol);
	}

	/**
	 * 根据指标周期获取Symbol列表
	 * 
	 * @param period
	 * @return
	 */
	private MutableIntObjectMap<ImmutableSet<TimeTwin>> getSymbolMap(IndicatorPeriod period) {
		MutableIntObjectMap<ImmutableSet<TimeTwin>> symbolMap = pools.get(period.getSeconds());
		if (symbolMap == null) {
			symbolMap = ECollections.newIntObjectHashMap();
			pools.put(period.getSeconds(), symbolMap);
		}
		return symbolMap;
	}

	/**
	 * 在指定Symbol列表中找出相应的时间分割点信息, 如果没有进行创建
	 * 
	 * @param symbolMap
	 * @param period
	 * @param symbol
	 * @return
	 */
	private ImmutableSet<TimeTwin> findOrCreate(MutableIntObjectMap<ImmutableSet<TimeTwin>> symbolMap,
			IndicatorPeriod period, Symbol symbol) {
		ImmutableSet<TimeTwin> immutableTimeTwinSet = symbolMap.get(symbol.getSymbolId());
		if (immutableTimeTwinSet != null)
			return immutableTimeTwinSet;
		MutableSet<TimeTwin> timeTwinSet = ECollections.newUnifiedSet();
		// 获取指定品种下的全部交易时段,将交易时段按照指定指标周期切分
		symbol.getTradingPeriodSet().forEach(tradingPeriod -> timeTwinSet
				.addAll(tradingPeriod.segmentByDuration(TradingDayKeeper.get(symbol), period.getDuration())));
		return symbolMap.put(symbol.getSymbolId(), timeTwinSet.toImmutable());
	}

}
