package io.ffreedom.polaris.indicators.pools;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.bar.BarSet;

public final class BarSettPool extends IndicatorPool<BarSet> {

	private static final BarSettPool INSTANCE = new BarSettPool();

	private BarSettPool() {
	}

	public static BarSet get(IndicatorPeriod period, Instrument instrument) {
		return INSTANCE.innerGet(period, instrument);
	}

	public static BarSet put(IndicatorPeriod period, Instrument instrument, BarSet barChart) {
		return INSTANCE.innerPut(period, instrument, barChart);
	}

	public static BarSet generate(IndicatorPeriod period, Instrument instrument) {
		BarSet barChart = new BarSet(instrument, period);
		return put(period, instrument, barChart);
	}

}
