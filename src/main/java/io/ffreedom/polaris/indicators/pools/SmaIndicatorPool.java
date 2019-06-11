package io.ffreedom.polaris.indicators.pools;

import javax.annotation.concurrent.NotThreadSafe;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.impl.ma.SmaIndicator;
import io.ffreedom.polaris.indicators.pools.base.MultiLayerIndicatorPool;

@NotThreadSafe
public class SmaIndicatorPool extends MultiLayerIndicatorPool<SmaIndicator> {

	public static final SmaIndicatorPool Singleton = new SmaIndicatorPool();

	private SmaIndicatorPool() {
	}

	@Override
	protected SmaIndicator generateIndicator(IndicatorTimePeriod period, CalculationCycle cycle, Instrument instrument) {
		return SmaIndicator.with(instrument, period, cycle);
	}

}