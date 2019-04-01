package io.ffreedom.polaris.indicators.pools;

import javax.annotation.concurrent.NotThreadSafe;

import org.eclipse.collections.api.map.primitive.ImmutableLongObjectMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.datetime.TradingPeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.financial.Symbol;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;

@NotThreadSafe
public final class TimePeriodPool {

	public static final TimePeriodPool Singleton = new TimePeriodPool();

	private TimePeriodPool() {
	}

	// Map<IndicatorPeriod, Map<Symbol, Set<TimePeriod>>>
	private MutableLongObjectMap<MutableIntObjectMap<ImmutableSortedSet<TimePeriod>>> timePeriodMap = ECollections
			.newLongObjectHashMap();

	// Map<IndicatorPeriod, Map<Symbol, Set<TimePeriod>>>
	private ImmutableLongObjectMap<ImmutableLongObjectMap<ImmutableSortedSet<TimePeriod>>> immutablePool;

	// Map<IndicatorPeriod, Map<Symbol, Map<SerialNumber, TimePeriod>>>
	private ImmutableLongObjectMap<ImmutableLongObjectMap<ImmutableLongObjectMap<TimePeriod>>> immutableMap;

	public void register(Symbol[] symbols, IndicatorPeriod... periods) {
		if (symbols == null)
			throw new IllegalArgumentException("Illegal Argument -> symbols is null");
		if (periods == null)
			throw new IllegalArgumentException("Illegal Argument -> periods in null");
		for (IndicatorPeriod period : periods)
			generateTimePeriod(symbols, period);
	}

	public TradingPeriod getNextTimePeriod(Symbol symbols, IndicatorPeriod period) {
		// TODO
		return null;
	}

	public TradingPeriod getNextTimePeriod(Instrument instrument, IndicatorPeriod period) {
		// TODO
		return null;
	}

	private void generateTimePeriod(Symbol[] symbols, IndicatorPeriod period) {
		MutableIntObjectMap<ImmutableSortedSet<TimePeriod>> symbolMap = getSymbolMap(period);
		for (Symbol symbol : symbols)
			findOrCreate(symbolMap, period, symbol);
	}

	public void toImmutable() {
		// TODO
	}

	/**
	 * 获取当前交易日下指定Symbol和指定指标周期下的全部时间分割点
	 * 
	 * @param period
	 * @param symbol
	 * @return
	 */
	public ImmutableSortedSet<TimePeriod> getTimePeriodSet(IndicatorPeriod period, Instrument instrument) {
		return getTimePeriodSet(period, instrument.getSymbol());
	}

	/**
	 * 获取当前交易日下指定Symbol和指定指标周期下的全部时间分割点
	 * 
	 * @param period
	 * @param symbol
	 * @return
	 */
	public ImmutableSortedSet<TimePeriod> getTimePeriodSet(IndicatorPeriod period, Symbol symbol) {
		return findOrCreate(getSymbolMap(period), period, symbol);
	}

	/**
	 * 根据指标周期获取Symbol列表
	 * 
	 * @param period
	 * @return
	 */
	private MutableIntObjectMap<ImmutableSortedSet<TimePeriod>> getSymbolMap(IndicatorPeriod period) {
		MutableIntObjectMap<ImmutableSortedSet<TimePeriod>> symbolMap = timePeriodMap.get(period.getSeconds());
		if (symbolMap == null) {
			symbolMap = ECollections.newIntObjectHashMap();
			timePeriodMap.put(period.getSeconds(), symbolMap);
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
	private ImmutableSortedSet<TimePeriod> findOrCreate(MutableIntObjectMap<ImmutableSortedSet<TimePeriod>> symbolMap,
			IndicatorPeriod period, Symbol symbol) {
		ImmutableSortedSet<TimePeriod> immutableTimePeriod = symbolMap.get(symbol.getSymbolId());
		if (immutableTimePeriod != null)
			return immutableTimePeriod;
		MutableSortedSet<TimePeriod> timePeriodSet = ECollections.newTreeSortedSet();
		// 获取指定品种下的全部交易时段,将交易时段按照指定指标周期切分
		symbol.getTradingPeriodSet()
				.forEach(tradingPeriod -> timePeriodSet.addAll(tradingPeriod.segmentByDuration(period.getDuration())));
		return symbolMap.put(symbol.getSymbolId(), timePeriodSet.toImmutable());
	}

}
