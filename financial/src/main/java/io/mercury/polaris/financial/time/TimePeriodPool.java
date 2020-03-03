package io.mercury.polaris.financial.time;

import javax.annotation.concurrent.ThreadSafe;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.ImmutableLongObjectMap;
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;

import io.mercury.common.collections.MutableMaps;
import io.mercury.common.collections.MutableSets;
import io.mercury.common.param.JointIdUtil;
import io.mercury.common.util.Assertor;
import io.mercury.polaris.financial.instrument.Instrument;
import io.mercury.polaris.financial.instrument.Symbol;
import io.mercury.polaris.vector.TimePeriod;
import io.mercury.polaris.vector.TimePeriodSerial;

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
	private MutableLongObjectMap<ImmutableSortedSet<TimePeriodSerial>> timePeriodSetsPool = MutableMaps
			.newLongObjectHashMap();

	/**
	 * 使用联合主键进行索引,高位为period, 低位为symbolId <br>
	 * 可变的Pool,最终元素为Map <br>
	 * Map<(period + symbolId), Map<SerialNumber,TimePeriod>>
	 */
	private MutableLongObjectMap<ImmutableLongObjectMap<TimePeriodSerial>> timePeriodMapsPool = MutableMaps
			.newLongObjectHashMap();

	/**
	 * 使用联合主键进行索引,高位为period, 低位为symbolId <br>
	 * 不可变的Pool,用于查询,最终元素为Set<br>
	 * Map<(period + symbolId), Set<TimePeriod>>
	 */
	private ImmutableLongObjectMap<ImmutableSortedSet<TimePeriodSerial>> immutableTimePeriodSetsPool;

	/**
	 * 使用联合主键进行索引,高位为period, 低位为symbolId <br>
	 * 不可变的Pool,用于查询,最终元素为Map <br>
	 * Map<(period + symbolId), Map<SerialNumber, TimePeriod>>
	 */
	private ImmutableLongObjectMap<ImmutableLongObjectMap<TimePeriodSerial>> immutableTimePeriodMapsPool;

	public void register(Symbol symbol, TimePeriod... periods) {
		register(new Symbol[] { symbol }, periods);
	}

	public void register(Symbol[] symbols, TimePeriod... periods) {
		Assertor.validArray(symbols, 1, "symbols");
		Assertor.validArray(periods, 1, "periods");	
		for (TimePeriod period : periods)
			generateTimePeriod(period, symbols);
		toImmutable();
	}

	private void generateTimePeriod(TimePeriod period, Symbol[] symbols) {
		for (Symbol symbol : symbols) {
			MutableSortedSet<TimePeriodSerial> timePeriodSet = MutableSets.newTreeSortedSet();
			MutableLongObjectMap<TimePeriodSerial> timePeriodMap = MutableMaps.newLongObjectHashMap();
			// 获取指定品种下的全部交易时段,将交易时段按照指定指标周期切分
			symbol.tradingPeriodSet().forEach(tradingPeriod -> {
				MutableList<TimePeriodSerial> segmentByDuration = tradingPeriod
						.segmentByDuration(symbol.exchange().zoneId(), period.duration());
				segmentByDuration.each(timePeriod -> {
					timePeriodSet.add(timePeriod);
					timePeriodMap.put(timePeriod.serialNumber(), timePeriod);
				});
			});
			long jointId = JointIdUtil.jointId((int) period.seconds(), symbol.id());
			timePeriodSetsPool.put(jointId, timePeriodSet.toImmutable());
			timePeriodMapsPool.put(jointId, timePeriodMap.toImmutable());
		}
	}

	private void toImmutable() {
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
	public ImmutableSortedSet<TimePeriodSerial> getTimePeriodSet(TimePeriod period, Instrument instrument) {
		return getTimePeriodSet(period, instrument.symbol());
	}

	/**
	 * 在指定Symbol列表中找出相应的时间分割点信息
	 * 
	 * @param symbolMap
	 * @param period
	 * @param symbol
	 * @return
	 */
	public ImmutableSortedSet<TimePeriodSerial> getTimePeriodSet(TimePeriod period, Symbol symbol) {
		long jointId = JointIdUtil.jointId(period.seconds(), symbol.id());
		return immutableTimePeriodSetsPool.get(jointId);
	}

	public TradingPeriod getNextTimePeriod(Instrument instrument, TimePeriod period, TimePeriodSerial timePeriod) {
		return getNextTimePeriod(instrument.symbol(), period, timePeriod);
	}

	public TradingPeriod getNextTimePeriod(Symbol symbol, TimePeriod period, TimePeriodSerial timePeriod) {
		long jointId = JointIdUtil.jointId(period.seconds(), symbol.id());
		immutableTimePeriodMapsPool.get(jointId);
		// TODO
		return null;
	}

}
