package io.polaris.indicators.pools;

import javax.annotation.concurrent.NotThreadSafe;

import io.polaris.financial.Instrument;
import io.polaris.indicators.api.CalculationCycle;
import io.polaris.indicators.api.IndicatorTimePeriod;
import io.polaris.indicators.impl.ma.SmaIndicator;
import io.polaris.indicators.pools.base.MultiLayerIndicatorPool;

@NotThreadSafe
public final class SmaIndicatorPool extends MultiLayerIndicatorPool<SmaIndicator> {

	public static final SmaIndicatorPool Singleton = new SmaIndicatorPool();

	private SmaIndicatorPool() {
	}

	@Override
	protected SmaIndicator generateIndicator(IndicatorTimePeriod period, CalculationCycle cycle, Instrument instrument) {
		return SmaIndicator.with(instrument, period, cycle);
	}

}
