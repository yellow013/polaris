package io.ffreedom.polaris.indicators.pools;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.Indicator;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.market.BasicMarketData;

public abstract class IndicatorPool<I extends Indicator<?>> {

	private MutableList<I> indicators = ECollections.newFastList();
	private MutableIntObjectMap<I> s1IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> s2IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> s5IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> s10IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> s15IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> s30IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> m1IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> m2IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> m5IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> m10IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> m15IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> m30IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> h1IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> h2IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> h4IndicatorMap = ECollections.newIntObjectHashMap(8);
	private MutableIntObjectMap<I> d1IndicatorMap = ECollections.newIntObjectHashMap(8);

	protected I innerGet(IndicatorPeriod period, Instrument instrument) {
		switch (period) {
		case S1:
			return s1IndicatorMap.get(instrument.getInstrumentId());
		case S2:
			return s2IndicatorMap.get(instrument.getInstrumentId());
		case S5:
			return s5IndicatorMap.get(instrument.getInstrumentId());
		case S10:
			return s10IndicatorMap.get(instrument.getInstrumentId());
		case S15:
			return s15IndicatorMap.get(instrument.getInstrumentId());
		case S30:
			return s30IndicatorMap.get(instrument.getInstrumentId());
		case M1:
			return m1IndicatorMap.get(instrument.getInstrumentId());
		case M2:
			return m2IndicatorMap.get(instrument.getInstrumentId());
		case M5:
			return m5IndicatorMap.get(instrument.getInstrumentId());
		case M10:
			return m10IndicatorMap.get(instrument.getInstrumentId());
		case M15:
			return m15IndicatorMap.get(instrument.getInstrumentId());
		case M30:
			return m30IndicatorMap.get(instrument.getInstrumentId());
		case H1:
			return h1IndicatorMap.get(instrument.getInstrumentId());
		case H2:
			return h2IndicatorMap.get(instrument.getInstrumentId());
		case H4:
			return h4IndicatorMap.get(instrument.getInstrumentId());
		case D1:
			return d1IndicatorMap.get(instrument.getInstrumentId());
		default:
			throw new IllegalArgumentException("period : " + period.name() + " is not found.b");
		}
	}

	protected I innerPut(IndicatorPeriod period, Instrument instrument, I i) {
		indicators.add(i);
		switch (period) {
		case S1:
			return s1IndicatorMap.put(instrument.getInstrumentId(), i);
		case S2:
			return s2IndicatorMap.put(instrument.getInstrumentId(), i);
		case S5:
			return s5IndicatorMap.put(instrument.getInstrumentId(), i);
		case S10:
			return s10IndicatorMap.put(instrument.getInstrumentId(), i);
		case S15:
			return s15IndicatorMap.put(instrument.getInstrumentId(), i);
		case S30:
			return s30IndicatorMap.put(instrument.getInstrumentId(), i);
		case M1:
			return m1IndicatorMap.put(instrument.getInstrumentId(), i);
		case M2:
			return m2IndicatorMap.put(instrument.getInstrumentId(), i);
		case M5:
			return m5IndicatorMap.put(instrument.getInstrumentId(), i);
		case M10:
			return m10IndicatorMap.put(instrument.getInstrumentId(), i);
		case M15:
			return m15IndicatorMap.put(instrument.getInstrumentId(), i);
		case M30:
			return m30IndicatorMap.put(instrument.getInstrumentId(), i);
		case H1:
			return h1IndicatorMap.put(instrument.getInstrumentId(), i);
		case H2:
			return h2IndicatorMap.put(instrument.getInstrumentId(), i);
		case H4:
			return h4IndicatorMap.put(instrument.getInstrumentId(), i);
		case D1:
			return d1IndicatorMap.put(instrument.getInstrumentId(), i);
		default:
			throw new IllegalArgumentException("period : " + period.name() + " is not found.b");
		}
	}

	public void onMarketDate(BasicMarketData marketData) {
		indicators.forEach(indicator -> indicator.onMarketData(marketData));

	}

}
