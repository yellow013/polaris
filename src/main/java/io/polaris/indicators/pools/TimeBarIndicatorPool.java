package io.polaris.indicators.pools;

import javax.annotation.concurrent.NotThreadSafe;

import io.polaris.financial.Instrument;
import io.polaris.indicators.api.IndicatorTimePeriod;
import io.polaris.indicators.impl.bar.TimeBarIndicator;
import io.polaris.indicators.pools.base.SingleLayerIndicatorPool;

@NotThreadSafe
public final class TimeBarIndicatorPool extends SingleLayerIndicatorPool<TimeBarIndicator> {

	public static final TimeBarIndicatorPool Singleton = new TimeBarIndicatorPool();

	private TimeBarIndicatorPool() {
	}

	@Override
	protected TimeBarIndicator generateIndicator(IndicatorTimePeriod period, Instrument instrument) {
		return new TimeBarIndicator(instrument, period);
	}

}
