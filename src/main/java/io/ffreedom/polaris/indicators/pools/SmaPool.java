package io.ffreedom.polaris.indicators.pools;

import javax.annotation.concurrent.NotThreadSafe;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.impl.ma.Sma1;
import io.ffreedom.polaris.indicators.pools.base.MultiLayerIndicatorPool;

@NotThreadSafe
public class SmaPool extends MultiLayerIndicatorPool<Sma1> {

	public static final SmaPool Singleton = new SmaPool();

	private SmaPool() {
	}

	@Override
	protected Sma1 generateIndicator(IndicatorTimePeriod period, CalculationCycle cycle, Instrument instrument) {
		return Sma1.with(instrument, period, cycle);
	}

}
