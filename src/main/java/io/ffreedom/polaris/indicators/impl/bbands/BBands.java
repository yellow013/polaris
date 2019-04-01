package io.ffreedom.polaris.indicators.impl.bbands;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractIndicator;
import io.ffreedom.polaris.market.BasicMarketData;

public class BBands extends AbstractIndicator<BBandsPoint> {

	public BBands(Instrument instrument, IndicatorPeriod period) {
		super(instrument, period, IndicatorCycle.with(1));
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		
	}

	@Override
	protected PointSet<BBandsPoint> initPoints() {
		return null;
	}

	@Override
	protected BBandsPoint initCurrentPoint() {
		return null;
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
