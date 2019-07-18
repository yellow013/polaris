package io.ffreedom.polaris.indicators.pools.base;

import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;

import io.ffreedom.common.collections.MutableMaps;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.BaseIndicator;

public abstract class SingleLayerIndicatorPool<I extends BaseIndicator<?, ?>> extends BaseIndicatorPool<I> {

	private MutableIntObjectMap<I> s1IndicatorMap = MutableMaps.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> s2IndicatorMap = MutableMaps.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> s5IndicatorMap = MutableMaps.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> s10IndicatorMap = MutableMaps.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> s15IndicatorMap = MutableMaps.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> s30IndicatorMap = MutableMaps.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> m1IndicatorMap = MutableMaps.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> m2IndicatorMap = MutableMaps.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> m5IndicatorMap = MutableMaps.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> m10IndicatorMap = MutableMaps.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> m15IndicatorMap = MutableMaps.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> m30IndicatorMap = MutableMaps.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> h1IndicatorMap = MutableMaps.newIntObjectHashMap(8);

	protected abstract I generateIndicator(IndicatorTimePeriod period, Instrument instrument);

	public I getIndicator(IndicatorTimePeriod period, Instrument instrument) {
		MutableIntObjectMap<I> indicatorMap = getIndicatorMap(period);
		I saved = indicatorMap.get(instrument.getInstrumentId());
		if (saved == null) {
			saved = generateIndicator(period, instrument);
			indicatorMap.put(instrument.getInstrumentId(), saved);
		}
		return saved;
	}

	public boolean putIndicator(IndicatorTimePeriod period, Instrument instrument, I indicator) {
		MutableIntObjectMap<I> indicatorMap = getIndicatorMap(period);
		I saved = indicatorMap.get(instrument.getInstrumentId());
		if (saved != null) {
			logger.warn("Indicator existed. period==[{}], instrumentCode==[{}]", period, instrument.getInstrumentId());
			return false;
		}
		indicatorMap.put(instrument.getInstrumentId(), indicator);
		return indicators.add(indicator);
	}

	private MutableIntObjectMap<I> getIndicatorMap(IndicatorTimePeriod period) {
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
		case M30:
			return m30IndicatorMap;
		case H1:
			return h1IndicatorMap;
		default:
			throw new IllegalArgumentException("period : " + period.name() + " is not found");
		}
	}

}
