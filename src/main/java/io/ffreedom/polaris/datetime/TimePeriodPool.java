package io.ffreedom.polaris.indicators.pools;

import javax.annotation.concurrent.ThreadSafe;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.ImmutableLongObjectMap;
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;

import io.ffreedom.common.collect.MutableMaps;
import io.ffreedom.common.collect.MutableSets;
import io.ffreedom.common.utils.JointIdUtil;
import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.datetime.TradingPeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.financial.Symbol;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;

@ThreadSafe
public final class TimePeriodPool {

	public static final TimePeriodPool Singleton = new TimePeriodPool();

	private TimePeriodPool() {
	}

	/**
	 * 使用联合主键进行索引,高位为period, 低位为symbolId <br>
	 * 可变的Pool,最终元素为Set <br>
	 * Map<(period + symbolId), Set<TimePeriod>>
	 */
	private MutableLongObjectMap<ImmutableSortedSet<TimePeriod>> timePeriodSetsPool = MutableMaps
			.newLongObjectHashMap();

	/**
	 * 使用联合主键进行索引,高位为period, 低位为symbolId <br>
	 * 可变的Pool,最终元素为Map <br>
	 * Map<(period + symbolId), Map<SerialNumber,TimePeriod>>
	 */
	private MutableLongObjectMap<ImmutableLongObjectMap<TimePeriod>> timePeriodMapsPool = MutableMaps
			.newLongObjectHashMap();

	/**
	 * 使用联合主键进行索引,高位为period, 低位为symbolId <br>
	 * 不可变的Pool,用于查询,最终元素为Set<br>
	 * Map<(period + symbolId), Set<TimePeriod>>
	 */
	private ImmutableLongObjectMap<ImmutableSortedSet<TimePeriod>> immutableTimePeriodSetsPool;

	/**
	 * 使用联合主键进行索引,高位为period, 低位为symbolId <br>
	 * 不可变的Pool,用于查询,最终元素为Map <br>
	 * Map<(period + symbolId), Map<SerialNumber, TimePeriod>>
	 */
	private ImmutableLongObjectMap<ImmutableLongObjectMap<TimePeriod>> immutableTimePeriodMapsPool;

	public void register(Symbol symbol, IndicatorTimePeriod... periods) {
		register(new Symbol[] { symbol }, periods);
	}

	public void register(Symbol[] symbols, IndicatorTimePeriod... periods) {
		if (symbols == null)
			throw new IllegalArgumentException("Illegal Argument -> symbols is null");
		if (periods == null)
			throw new IllegalArgumentException("Illegal Argument -> periods in null");
		for (IndicatorTimePeriod period : periods)
			generateTimePeriod(period, symbols);
		toImmutable();
	}

	private void generateTimePeriod(IndicatorTimePeriod period, Symbol[] symbols) {
		for (Symbol symbol : symbols) {
			MutableSortedSet<TimePeriod> timePeriodSet = MutableSets.newTreeSortedSet();
			MutableLongObjectMap<TimePeriod> timePeriodMap = MutableMaps.newLongObjectHashMap();
			// 获取指定品种下的全部交易时段,将交易时段按照指定指标周期切分
			symbol.getTradingPeriodSet().forEach(tradingPeriod -> {
				MutableList<TimePeriod> segmentByDuration = tradingPeriod.segmentByDuration(period.getDuration());
				segmentByDuration.each(timePeriod -> {
					timePeriodSet.add(timePeriod);
					timePeriodMap.put(timePeriod.getSerialNumber(), timePeriod);
				});
			});
			long jointId = JointIdUtil.jointId((int) period.getSeconds(), symbol.getSymbolId());
			timePeriodSetsPool.put(jointId, timePeriodSet.toImmutable());
			timePeriodMapsPool.put(jointId, timePeriodMap.toImmutable());
		}
	}

	public void toImmutable() {
		this.immutableTimePeriodSetsPool = timePeriodSetsPool.toImmutable();
		this.immutableTimePeriodMapsPool = timePeriodMapsPool.toImmutable();
	}

	/**
	 * 获取指定Instrument和指定指标周期下的全部时间分割点
	 * 
	 * @param period
	 * @param symbol
	 * @return
	 */
	public ImmutableSortedSet<TimePeriod> getTimePeriodSet(IndicatorTimePeriod period, Instrument instrument) {
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
	public ImmutableSortedSet<TimePeriod> getTimePeriodSet(IndicatorTimePeriod period, Symbol symbol) {
		long jointId = JointIdUtil.jointId((int) period.getSeconds(), symbol.getSymbolId());
		return immutableTimePeriodSetsPool.get(jointId);
	}

	public TradingPeriod getNextTimePeriod(Instrument instrument, IndicatorTimePeriod period, TimePeriod timePeriod) {
		return getNextTimePeriod(instrument.getSymbol(), period, timePeriod);
	}

	public TradingPeriod getNextTimePeriod(Symbol symbol, IndicatorTimePeriod period, TimePeriod timePeriod) {
		long jointId = JointIdUtil.jointId((int) period.getSeconds(), symbol.getSymbolId());
		immutableTimePeriodMapsPool.get(jointId);
		// TODO
		return null;
	}

}
