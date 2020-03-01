package io.mercury.polaris.indicator.pools;

import javax.annotation.concurrent.NotThreadSafe;

import io.mercury.polaris.financial.instrument.Instrument;
import io.mercury.polaris.indicator.impl.bar.TimeBarIndicator;
import io.mercury.polaris.indicator.pools.base.SingleLayerIndicatorPool;
import io.mercury.polaris.vector.TimePeriod;

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
