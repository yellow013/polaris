package io.ffreedom.polaris.indicators.pools.base;

import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;

import io.ffreedom.common.collections.MutableMaps;
import io.ffreedom.common.utils.JointIdUtil;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.BaseIndicator;

public abstract class MultiLayerIndicatorPool<I extends BaseIndicator<?, ?>> extends BaseIndicatorPool<I> {

	private MutableLongObjectMap<I> s1IndicatorMap = MutableMaps.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> s2IndicatorMap = MutableMaps.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> s5IndicatorMap = MutableMaps.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> s10IndicatorMap = MutableMaps.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> s15IndicatorMap = MutableMaps.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> s30IndicatorMap = MutableMaps.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> m1IndicatorMap = MutableMaps.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> m2IndicatorMap = MutableMaps.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> m5IndicatorMap = MutableMaps.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> m10IndicatorMap = MutableMaps.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> m15IndicatorMap = MutableMaps.newLongObjectHashMap(8);

	protected abstract I generateIndicator(IndicatorTimePeriod period, CalculationCycle cycle, Instrument instrument);

	public I getIndicator(IndicatorTimePeriod period, CalculationCycle cycle, Instrument instrument) {
		MutableLongObjectMap<I> indicatorMap = getIndicatorMap(period);
		long index = calculateIndex(cycle, instrument);
		I saved = indicatorMap.get(index);
		if (saved == null) {
			saved = generateIndicator(period, cycle, instrument);
			indicatorMap.put(index, saved);
		}
		return saved;
	}

	public boolean putIndicator(IndicatorTimePeriod period, CalculationCycle cycle, Instrument instrument,
			I indicator) {
		MutableLongObjectMap<I> indicatorMap = getIndicatorMap(period);
		long index = calculateIndex(cycle, instrument);
		I saved = indicatorMap.get(index);
		if (saved != null) {
			logger.warn("Indicator existed. period==[{}], instrumentCode==[{}], cycle==[{}]", period,
					instrument.getInstrumentId(), cycle);
			return false;
		}
		indicatorMap.put(index, indicator);
		return indicators.add(indicator);
	}

	private long calculateIndex(CalculationCycle cycle, Instrument instrument) {
		return JointIdUtil.jointId(cycle.getCycleValue(), instrument.getInstrumentId());
	}

	private MutableLongObjectMap<I> getIndicatorMap(IndicatorTimePeriod period) {
		switch (period) {
		case S1:
			return s1IndicatorMap;
		case S2:
			return s2IndicatorMap;
		case S5:
			return s5IndicatorMap;
		case S10:
			return s10IndicatorMap;
		case S15:
			return s15IndicatorMap;
		case S30:
			return s30IndicatorMap;
		case M1:
			return m1IndicatorMap;
		case M2:
			return m2IndicatorMap;
		case M5:
			return m5IndicatorMap;
		case M10:
			return m10IndicatorMap;
		case M15:
			return m15IndicatorMap;
		default:
			throw new IllegalArgumentException("period : " + period.name() + " is not found");
		}
	}

}
