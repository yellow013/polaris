package io.ffreedom.polaris.indicators.pools;

import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.datetime.tradingday.TradingDayKeeper;
import io.ffreedom.polaris.financial.Symbol;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;

public final class TimeTwinPool {

	private static final TimeTwinPool INSTANCE = new TimeTwinPool();

	// Map<IndicatorPeriod, Map<Symbol, Set<TimeTwin>>>
	private MutableLongObjectMap<MutableIntObjectMap<ImmutableSet<TimePeriod>>> pools = ECollections
			.newLongObjectHashMap();

	public static void register(Symbol[] symbols, IndicatorPeriod... periods) {
		if (symbols == null)
			throw new IllegalArgumentException("Illegal Argument -> symbols is null");
		if (periods == null)
			throw new IllegalArgumentException("Illegal Argument -> periods in null");
		for (IndicatorPeriod period : periods) {
			INSTANCE.register0(symbols, period);
		}
	}

	private void register0(Symbol[] symbols, IndicatorPeriod period) {
		MutableIntObjectMap<ImmutableSet<TimePeriod>> symbolMap = getSymbolMap(period);
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
	public static ImmutableSet<TimePeriod> getTimePeriodSet(IndicatorPeriod period, Symbol symbol) {
		return INSTANCE.findOrCreate(INSTANCE.getSymbolMap(period), period, symbol);
	}

	/**
	 * 根据指标周期获取Symbol列表
	 * 
	 * @param period
	 * @return
	 */
	private MutableIntObjectMap<ImmutableSet<TimePeriod>> getSymbolMap(IndicatorPeriod period) {
		MutableIntObjectMap<ImmutableSet<TimePeriod>> symbolMap = pools.get(period.getSeconds());
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
	private ImmutableSet<TimePeriod> findOrCreate(MutableIntObjectMap<ImmutableSet<TimePeriod>> symbolMap,
			IndicatorPeriod period, Symbol symbol) {
		ImmutableSet<TimePeriod> immutableTimeTwinSet = symbolMap.get(symbol.getSymbolId());
		if (immutableTimeTwinSet != null)
			return immutableTimeTwinSet;
		MutableSet<TimePeriod> timePeriodSet = ECollections.newUnifiedSet();
		// 获取指定品种下的全部交易时段,将交易时段按照指定指标周期切分
		symbol.getTradingPeriodSet().forEach(tradingPeriod -> timePeriodSet
				.addAll(tradingPeriod.segmentByDuration(TradingDayKeeper.get(symbol), period.getDuration())));
		return symbolMap.put(symbol.getSymbolId(), timePeriodSet.toImmutable());
	}

}
