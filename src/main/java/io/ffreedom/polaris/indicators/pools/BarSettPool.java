package io.ffreedom.polaris.indicators.pools;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.bar.BarChart;

public final class BarChartPool extends IndicatorPool<BarChart> {

	private static final BarChartPool INSTANCE = new BarChartPool();

	private BarChartPool() {
	}

	public static BarChart get(IndicatorPeriod period, Instrument instrument) {
		return INSTANCE.innerGet(period, instrument);
	}

	public static BarChart put(IndicatorPeriod period, Instrument instrument, BarChart barChart) {
		return INSTANCE.innerPut(period, instrument, barChart);
	}
	
	public void register() {
		
	}

}
