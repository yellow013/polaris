package io.ffreedom.polaris.indicators.pools;

import javax.annotation.concurrent.NotThreadSafe;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.ma.SMA;
import io.ffreedom.polaris.indicators.pools.base.MultiLayerIndicatorPool;

@NotThreadSafe
public class SmaPool extends MultiLayerIndicatorPool<SMA> {

	public static final SmaPool Singleton = new SmaPool();

	private SmaPool() {
	}

	@Override
	protected SMA generateIndicator(IndicatorPeriod period, Instrument instrument, IndicatorCycle cycle) {
		return SMA.with(instrument, period, cycle);
	}

}
