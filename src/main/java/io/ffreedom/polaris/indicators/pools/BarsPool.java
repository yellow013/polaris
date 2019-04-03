package io.ffreedom.polaris.indicators.pools;

import javax.annotation.concurrent.NotThreadSafe;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.bar.BarSet;
import io.ffreedom.polaris.indicators.pools.base.SingleLayerIndicatorPool;

@NotThreadSafe
public final class BarSetPool extends SingleLayerIndicatorPool<BarSet> {

	public static final BarSetPool Singleton = new BarSetPool();

	private BarSetPool() {
	}

	@Override
	protected BarSet generateIndicator(IndicatorPeriod period, Instrument instrument) {
		return new BarSet(instrument, period);
	}

}
