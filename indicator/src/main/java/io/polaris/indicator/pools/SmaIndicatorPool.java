package io.polaris.indicator.pools;

import javax.annotation.concurrent.NotThreadSafe;

import io.polaris.financial.instrument.Instrument;
import io.polaris.indicator.api.CalculationCycle;
import io.polaris.indicator.impl.ma.SmaIndicator;
import io.polaris.indicator.pools.base.MultiLayerIndicatorPool;
import io.polaris.vector.TimePeriod;

@NotThreadSafe
public final class SmaIndicatorPool extends MultiLayerIndicatorPool<SmaIndicator> {

	public static final SmaIndicatorPool Singleton = new SmaIndicatorPool();

	private SmaIndicatorPool() {
	}

	@Override
	protected SmaIndicator generateIndicator(TimePeriod period, CalculationCycle cycle, Instrument instrument) {
		return SmaIndicator.with(instrument, period, cycle);
	}

}
