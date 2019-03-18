package io.ffreedom.polaris.indicators.pools;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.ma.SMA;
import io.ffreedom.polaris.indicators.pools.base.MultiLayerIndicatorPool;

public class SMAPool extends MultiLayerIndicatorPool<SMA> {

	private static final SMAPool singleton = new SMAPool();

	private SMAPool() {
	}

	public static SMAPool getSingleton() {
		return singleton;
	}

	@Override
	protected SMA generateIndicator(IndicatorPeriod period, Instrument instrument, IndicatorCycle cycle) {
		return SMA.with(instrument, period, cycle);
	}

}
