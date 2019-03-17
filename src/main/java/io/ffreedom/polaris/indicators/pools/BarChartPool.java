package io.ffreedom.polaris.indicators.pools;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.bar.BarChart;

public final class BarChartPools extends IndicatorPool<BarChart> {

	private static final BarChartPools INSTANCE = new BarChartPools();

	private BarChartPools() {
	}

	public static BarChart get(IndicatorPeriod period, Instrument instrument) {
		return INSTANCE.innerGet(period, instrument);
	}

	public static BarChart put(IndicatorPeriod period, Instrument instrument, BarChart barChart) {
		return INSTANCE.innerPut(period, instrument, barChart);
	}

}
