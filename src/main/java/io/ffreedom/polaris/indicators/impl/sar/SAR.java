package io.ffreedom.polaris.indicators.impl.sar;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractIndicator;
import io.ffreedom.polaris.market.BasicMarketData;

public class SAR extends AbstractIndicator<SARPoint> {

	public SAR(Instrument instrument, IndicatorPeriod period) {
		super(instrument, period, IndicatorCycle.with(2));
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {

	}

	@Override
	protected PointSet<SARPoint> initPoints() {
		return null;
	}

	@Override
	protected SARPoint initCurrentPoint() {
		return null;
	}

}
