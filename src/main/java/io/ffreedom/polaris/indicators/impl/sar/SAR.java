package io.ffreedom.polaris.indicators.impl.sar;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractPooledIndicator;
import io.ffreedom.polaris.indicators.impl.sar.point.SARPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class SAR extends AbstractPooledIndicator<SARPoint> {

	public SAR(Instrument instrument, IndicatorPeriod period) {
		super(instrument, period, IndicatorCycle.with(2));
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {

	}

	@Override
	protected void initPooledPoints(PointSet<SARPoint> points) {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isCurrentPointPeriod(BasicMarketData marketData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected SARPoint generateNextPoint(SARPoint currentPoint) {
		// TODO Auto-generated method stub
		return null;
	}

}
