package io.ffreedom.polaris.indicators.pools.base;

import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.AbstractPooledIndicator;
import io.ffreedom.polaris.market.BasicMarketData;

public abstract class MultiLayerIndicatorPool<I extends AbstractPooledIndicator<?, ?>> extends BaseIndicatorPool<I> {

	private MutableLongObjectMap<I> s1IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> s2IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> s5IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> s10IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> s15IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> s30IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> m1IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> m2IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> m5IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> m10IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> m15IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> m30IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> h1IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> h2IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> h4IndicatorMap = ECollections.newLongObjectHashMap(8);
	private MutableLongObjectMap<I> d1IndicatorMap = ECollections.newLongObjectHashMap(8);

	protected abstract I generateIndicator(IndicatorPeriod period, Instrument instrument, IndicatorCycle cycle);

	public void onMarketDate(BasicMarketData marketData) {
		indicators.forEach(indicator -> indicator.onMarketData(marketData));
	}

	public I getIndicator(IndicatorPeriod period, Instrument instrument, IndicatorCycle cycle) {
		MutableLongObjectMap<I> indicatorMap = getIndicatorMap(period);
		long index = calculateIndex(instrument, cycle);
		I saved = indicatorMap.get(index);
		if (saved == null) {
			saved = generateIndicator(period, instrument, cycle);
			indicatorMap.put(index, saved);
		}
		return saved;
	}

	public boolean putIndicator(IndicatorPeriod period, Instrument instrument, IndicatorCycle cycle, I indicator) {
		MutableLongObjectMap<I> indicatorMap = getIndicatorMap(period);
		long index = calculateIndex(instrument, cycle);
		I saved = indicatorMap.get(index);
		if (saved != null) {
			logger.warn("Indicator existed. period==[{}], instrumentCode==[{}], cycle==[{}]", period,
					instrument.getInstrumentId(), cycle);
			return false;
		}
		indicatorMap.put(index, indicator);
		return indicators.add(indicator);
	}

	private long calculateIndex(Instrument instrument, IndicatorCycle cycle) {
		return instrument.getInstrumentId() * 1000000L + cycle.getValue();
	}

	private MutableLongObjectMap<I> getIndicatorMap(IndicatorPeriod period) {
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
		case H2:
			return h2IndicatorMap;
		case H4:
			return h4IndicatorMap;
		case D1:
			return d1IndicatorMap;
		default:
			throw new IllegalArgumentException("period : " + period.name() + " is not found.b");
		}
	}

}
