package io.ffreedom.polaris.indicators.impl.bbands;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.events.BBandsEvent;
import io.ffreedom.polaris.indicators.impl.AbstractPooledIndicator;
import io.ffreedom.polaris.indicators.impl.bbands.point.BBandsPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class BBands extends AbstractPooledIndicator<BBandsPoint, BBandsEvent> {

	public BBands(Instrument instrument, IndicatorPeriod period) {
		super(instrument, period, IndicatorCycle.with(1));
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {

	}

	@Override
	protected void initPooledPoints(PointSet<BBandsPoint> points) {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isCurrentPointPeriod(BasicMarketData marketData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected BBandsPoint generateNextPoint(BBandsPoint currentPoint) {
		// TODO Auto-generated method stub
		return null;
	}

}
