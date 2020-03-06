package io.mercury.polaris.financial.time;

import java.util.stream.Collectors;

import javax.annotation.CheckForNull;
import javax.annotation.concurrent.NotThreadSafe;

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
import io.mercury.polaris.financial.vector.TimePeriod;
import io.mercury.polaris.financial.vector.TimePeriodSerial;

@NotThreadSafe
public final class TimePeriodPool {

	public static final TimePeriodPool Singleton = new TimePeriodPool();

	private TimePeriodPool() {
	}

	/**
	 * 使用联合主键进行索引,高位为symbolId, 低位为period <br>
	 * 可变的Pool,最终元素为Set <br>
	 * Map<(period + symbolId), Set<TimePeriod>>
	 */
	private MutableLongObjectMap<ImmutableSortedSet<TimePeriodSerial>> timePeriodSetPool = MutableMaps
			.newLongObjectHashMap();

	/**
	 * 使用联合主键进行索引,高位为symbolId, 低位为period <br>
	 * 可变的Pool,最终元素为Map <br>
	 * Map<(period + symbolId), Map<SerialNumber,TimePeriod>>
	 */
	private MutableLongObjectMap<ImmutableLongObjectMap<TimePeriodSerial>> timePeriodMapPool = MutableMaps
			.newLongObjectHashMap();

	public void register(Symbol symbol, TimePeriod... periods) {
		register(new Symbol[] { symbol }, periods);
	}

	public void register(Symbol[] symbols, TimePeriod... periods) {
		Assertor.validArray(symbols, 1, "symbols");
		Assertor.validArray(periods, 1, "periods");
		for (TimePeriod period : periods)
			generateTimePeriod(symbols, period);
	}

	private void generateTimePeriod(Symbol[] symbols, TimePeriod period) {
		for (Symbol symbol : symbols) {
			MutableSortedSet<TimePeriodSerial> timePeriodSet = MutableSets.newTreeSortedSet();
			MutableLongObjectMap<TimePeriodSerial> timePeriodMap = MutableMaps.newLongObjectHashMap();
			// 获取指定品种下的全部交易时段,将交易时段按照指定指标周期切分
			symbol.tradingPeriodSet().stream().flatMap(
					tradingPeriod -> tradingPeriod.segmentation(symbol.exchange().zoneId(), period.duration()).stream())
					.collect(Collectors.toList()).forEach(serial -> {
						timePeriodSet.add(serial);
						timePeriodMap.put(serial.serialNumber(), serial);
					});
			long jointId = JointIdUtil.jointId(symbol.id(), (int) period.seconds());
			timePeriodSetPool.put(jointId, timePeriodSet.toImmutable());
			timePeriodMapPool.put(jointId, timePeriodMap.toImmutable());
		}
	}

	/**
	 * 获取指定Instrument和指定指标周期下的全部时间分割点
	 * 
	 * @param period
	 * @param symbol
	 * @return
	 */
	public ImmutableSortedSet<TimePeriodSerial> getTimePeriodSet(Instrument instrument, TimePeriod period) {
		return getTimePeriodSet(instrument.symbol(), period);
	}

	/**
	 * 在指定Symbol列表中找出相应的时间分割点信息
	 * 
	 * @param symbolMap
	 * @param period
	 * @param symbol
	 * @return
	 */
	public ImmutableSortedSet<TimePeriodSerial> getTimePeriodSet(Symbol symbol, TimePeriod period) {
		long jointId = JointIdUtil.jointId(symbol.id(), period.seconds());
		ImmutableSortedSet<TimePeriodSerial> sortedSet = timePeriodSetPool.get(jointId);
		if (sortedSet == null) {
			register(symbol, period);
			sortedSet = timePeriodSetPool.get(jointId);
		}
		return sortedSet;
	}

	public ImmutableLongObjectMap<TimePeriodSerial> getTimePeriodMap(Instrument instrument, TimePeriod period) {
		return getTimePeriodMap(instrument.symbol(), period);
	}

	public ImmutableLongObjectMap<TimePeriodSerial> getTimePeriodMap(Symbol symbol, TimePeriod period) {
		long jointId = JointIdUtil.jointId(symbol.id(), period.seconds());
		ImmutableLongObjectMap<TimePeriodSerial> longObjectMap = timePeriodMapPool.get(jointId);
		if (longObjectMap == null) {
			register(symbol, period);
			longObjectMap = timePeriodMapPool.get(jointId);
		}
		return longObjectMap;
	}

	public TimePeriodSerial getNextTimePeriod(Instrument instrument, TimePeriod period, TimePeriodSerial serial) {
		return getNextTimePeriod(instrument.symbol(), period, serial);
	}

	@CheckForNull
	public TimePeriodSerial getNextTimePeriod(Symbol symbol, TimePeriod period, TimePeriodSerial serial) {
		ImmutableLongObjectMap<TimePeriodSerial> longObjectMap = getTimePeriodMap(symbol, period);
		return longObjectMap.get(serial.serialNumber() + period.seconds());
	}

}
