package io.ffreedom.polaris.indicators.pools;

import javax.annotation.concurrent.ThreadSafe;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
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

@ThreadSafe
public final class TimePeriodPool {

	public static final TimePeriodPool Singleton = new TimePeriodPool();

	private TimePeriodPool() {
	}

	/**
	 * 可变的Pool,最终元素为Set <br>
	 * Map<IndicatorPeriod, Map<Symbol, Set<TimePeriod>>>
	 */
	private MutableLongObjectMap<MutableIntObjectMap<ImmutableSortedSet<TimePeriod>>> timePeriodSetsPool = ECollections
			.newLongObjectHashMap();

	/**
	 * 可变的Pool,最终元素为Map <br>
	 * Map<IndicatorPeriod, Map<Symbol, Map<SerialNumber,TimePeriod>>>
	 */
	private MutableLongObjectMap<MutableIntObjectMap<ImmutableLongObjectMap<TimePeriod>>> timePeriodMapsPool = ECollections
			.newLongObjectHashMap();

	/**
	 * 不可变的Pool,用于查询,最终元素为Set<br>
	 * Map<IndicatorPeriod, Map<Symbol, Set<TimePeriod>>>
	 */
	private ImmutableLongObjectMap<ImmutableIntObjectMap<ImmutableSortedSet<TimePeriod>>> immutableTimePeriodSetsPool;

	/**
	 * 不可变的Pool,用于查询,最终元素为Map <br>
	 * Map<IndicatorPeriod, Map<Symbol, Map<SerialNumber, TimePeriod>>>
	 */
	private ImmutableLongObjectMap<ImmutableIntObjectMap<ImmutableLongObjectMap<TimePeriod>>> immutableTimePeriodMapsPool;

	public void register(Symbol[] symbols, IndicatorPeriod... periods) {
		if (symbols == null)
			throw new IllegalArgumentException("Illegal Argument -> symbols is null");
		if (periods == null)
			throw new IllegalArgumentException("Illegal Argument -> periods in null");
		for (IndicatorPeriod period : periods)
			generateTimePeriod(symbols, period);
		toImmutable();
	}

	private void generateTimePeriod(Symbol[] symbols, IndicatorPeriod period) {
		MutableIntObjectMap<ImmutableSortedSet<TimePeriod>> symbolSets = timePeriodSetsPool.get(period.getSeconds());
		MutableIntObjectMap<ImmutableLongObjectMap<TimePeriod>> symbolMaps = timePeriodMapsPool
				.get(period.getSeconds());
		if (symbolSets == null) {
			symbolSets = ECollections.newIntObjectHashMap();
			timePeriodSetsPool.put(period.getSeconds(), symbolSets);
		}
		if (symbolMaps == null) {
			symbolMaps = ECollections.newIntObjectHashMap();
			timePeriodMapsPool.put(period.getSeconds(), symbolMaps);
		}
		for (Symbol symbol : symbols) {
			MutableSortedSet<TimePeriod> timePeriodSet = ECollections.newTreeSortedSet();
			MutableLongObjectMap<TimePeriod> timePeriodMap = ECollections.newLongObjectHashMap();
			// 获取指定品种下的全部交易时段,将交易时段按照指定指标周期切分
			symbol.getTradingPeriodSet().forEach(tradingPeriod -> {
				MutableList<TimePeriod> segmentByDuration = tradingPeriod.segmentByDuration(period.getDuration());
				timePeriodSet.addAll(segmentByDuration);
				segmentByDuration.each(timePeriod -> {
					timePeriodMap.put(timePeriod.getSerialNumber(), timePeriod);
				});
			});
			symbolSets.put(symbol.getSymbolId(), timePeriodSet.toImmutable());
			symbolMaps.put(symbol.getSymbolId(), timePeriodMap.toImmutable());
		}
	}

	public void toImmutable() {
		// 创建临时的可变结构,内部包含不可变的结构.
		MutableLongObjectMap<ImmutableIntObjectMap<ImmutableSortedSet<TimePeriod>>> tempSetsPool = ECollections
				.newLongObjectHashMap();
		// 将可变Pool中的元素转移到临时池中,将元素转换为不可变
		timePeriodSetsPool.forEachKeyValue(
				(long period, MutableIntObjectMap<ImmutableSortedSet<TimePeriod>> value) -> tempSetsPool.put(period,
						value.toImmutable()));
		// 将临时可变次转换为最终查询使用的不可变池
		this.immutableTimePeriodSetsPool = tempSetsPool.toImmutable();

		// 创建临时的可变结构,内部包含不可变的结构.
		MutableLongObjectMap<ImmutableIntObjectMap<ImmutableLongObjectMap<TimePeriod>>> tempMapsPool = ECollections
				.newLongObjectHashMap();
		// 将可变Pool中的元素转移到临时池中,将元素转换为不可变
		timePeriodMapsPool.forEachKeyValue(
				(long period, MutableIntObjectMap<ImmutableLongObjectMap<TimePeriod>> value) -> tempMapsPool.put(period,
						value.toImmutable()));
		this.immutableTimePeriodMapsPool = tempMapsPool.toImmutable();
	}

	/**
	 * 获取指定Instrument和指定指标周期下的全部时间分割点
	 * 
	 * @param period
	 * @param symbol
	 * @return
	 */
	public ImmutableSortedSet<TimePeriod> getTimePeriodSet(IndicatorPeriod period, Instrument instrument) {
		return getTimePeriodSet(period, instrument.getSymbol());
	}

	/**
	 * 在指定Symbol列表中找出相应的时间分割点信息
	 * 
	 * @param symbolMap
	 * @param period
	 * @param symbol
	 * @return
	 */
	public ImmutableSortedSet<TimePeriod> getTimePeriodSet(IndicatorPeriod period, Symbol symbol) {
		return immutableTimePeriodSetsPool.get(period.getSeconds()).get(symbol.getSymbolId());
	}

	public TradingPeriod getNextTimePeriod(Instrument instrument, IndicatorPeriod period, TimePeriod timePeriod) {
		return getNextTimePeriod(instrument.getSymbol(), period, timePeriod);
	}

	public TradingPeriod getNextTimePeriod(Symbol symbol, IndicatorPeriod period, TimePeriod timePeriod) {
		ImmutableLongObjectMap<TimePeriod> immutableLongObjectMap = immutableTimePeriodMapsPool.get(period.getSeconds())
				.get(symbol.getSymbolId());
		// TODO
		return null;
	}

}
