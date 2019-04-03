package io.ffreedom.polaris.indicators.pools;

import javax.annotation.concurrent.NotThreadSafe;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.bar.PooledBars;
import io.ffreedom.polaris.indicators.pools.base.SingleLayerIndicatorPool;

@NotThreadSafe
public final class BarsPool extends SingleLayerIndicatorPool<PooledBars> {

	public static final BarsPool Singleton = new BarsPool();

	private BarsPool() {
	}

	@Override
	protected PooledBars generateIndicator(IndicatorPeriod period, Instrument instrument) {
		return new PooledBars(instrument, period);
	}

}
