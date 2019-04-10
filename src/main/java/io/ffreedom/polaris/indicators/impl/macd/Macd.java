package io.ffreedom.polaris.indicators.impl.macd;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.events.MacdEvent;
import io.ffreedom.polaris.indicators.impl.AbstractPooledIndicator;
import io.ffreedom.polaris.indicators.impl.macd.point.MacdPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public final class Macd extends AbstractPooledIndicator<MacdPoint, MacdEvent> {

	public Macd(Instrument instrument, IndicatorPeriod period) {
		super(instrument, period, IndicatorCycle.with(26));
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initPooledPoints(PointSet<MacdPoint> points) {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isCurrentPointPeriod(BasicMarketData marketData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected MacdPoint generateNextPoint(MacdPoint currentPoint) {
		// TODO Auto-generated method stub
		return null;
	}

}