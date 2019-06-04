package io.ffreedom.polaris.indicators.pools;

import javax.annotation.concurrent.NotThreadSafe;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.impl.bar.TimeBars;
import io.ffreedom.polaris.indicators.pools.base.SingleLayerIndicatorPool;

@NotThreadSafe
public final class BarsPool extends SingleLayerIndicatorPool<TimeBars> {

	public static final BarsPool Singleton = new BarsPool();

	private BarsPool() {
	}

	@Override
	protected TimeBars generateIndicator(IndicatorTimePeriod period, Instrument instrument) {
		return new TimeBars(instrument, period);
	}

}
