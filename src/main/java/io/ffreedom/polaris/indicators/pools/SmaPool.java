package io.ffreedom.polaris.indicators.pools;

import javax.annotation.concurrent.NotThreadSafe;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.ma.PooledSma;
import io.ffreedom.polaris.indicators.pools.base.MultiLayerIndicatorPool;

@NotThreadSafe
public class SmaPool extends MultiLayerIndicatorPool<PooledSma> {

	public static final SmaPool Singleton = new SmaPool();

	private SmaPool() {
	}

	@Override
	protected PooledSma generateIndicator(IndicatorPeriod period, Instrument instrument, IndicatorCycle cycle) {
		return PooledSma.with(instrument, period, cycle);
	}

}
