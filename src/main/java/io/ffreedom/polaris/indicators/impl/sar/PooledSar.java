package io.ffreedom.polaris.indicators.impl.sar;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractPooledIndicator;
import io.ffreedom.polaris.indicators.impl.sar.point.SarPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class PooledSar extends AbstractPooledIndicator<SarPoint> {

	public PooledSar(Instrument instrument, IndicatorPeriod period) {
		super(instrument, period, IndicatorCycle.with(2));
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {

	}

	@Override
	protected void initPooledPoints(PointSet<SarPoint> points) {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isCurrentPointPeriod(BasicMarketData marketData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected SarPoint generateNextPoint(SarPoint currentPoint) {
		// TODO Auto-generated method stub
		return null;
	}

}
