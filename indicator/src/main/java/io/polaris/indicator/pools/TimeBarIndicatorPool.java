package io.polaris.indicator.pools;

import javax.annotation.concurrent.NotThreadSafe;

import io.polaris.financial.instrument.Instrument;
import io.polaris.indicator.impl.bar.TimeBarIndicator;
import io.polaris.indicator.pools.base.SingleLayerIndicatorPool;
import io.polaris.vector.TimePeriod;

@NotThreadSafe
public final class TimeBarIndicatorPool extends SingleLayerIndicatorPool<TimeBarIndicator> {

	public static final TimeBarIndicatorPool Singleton = new TimeBarIndicatorPool();

	private TimeBarIndicatorPool() {
	}

	@Override
	protected TimeBarIndicator generateIndicator(TimePeriod period, Instrument instrument) {
		return new TimeBarIndicator(instrument, period);
	}

}
