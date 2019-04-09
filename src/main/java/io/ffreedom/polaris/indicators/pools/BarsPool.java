package io.ffreedom.polaris.indicators.pools;

import javax.annotation.concurrent.NotThreadSafe;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.bar.PooledTimeBars;
import io.ffreedom.polaris.indicators.pools.base.SingleLayerIndicatorPool;

@NotThreadSafe
public final class BarsPool extends SingleLayerIndicatorPool<PooledTimeBars> {

	public static final BarsPool Singleton = new BarsPool();

	private BarsPool() {
	}

	@Override
	protected PooledTimeBars generateIndicator(IndicatorPeriod period, Instrument instrument) {
		return new PooledTimeBars(instrument, period);
	}

}
