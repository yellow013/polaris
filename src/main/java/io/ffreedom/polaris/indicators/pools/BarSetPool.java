package io.ffreedom.polaris.indicators.pools;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.bar.BarSet;
import io.ffreedom.polaris.indicators.pools.base.SingleLayerIndicatorPool;

public final class BarSetPool extends SingleLayerIndicatorPool<BarSet> {

	private static final BarSetPool singleton = new BarSetPool();

	private BarSetPool() {
	}

	public static BarSetPool getSingleton() {
		return singleton;
	}

	@Override
	protected BarSet generateIndicator(IndicatorPeriod period, Instrument instrument) {
		return new BarSet(instrument, period);
	}

}
