package io.ffreedom.polaris.indicators.impl.bbands.point;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class BBandsPoint extends TimePeriodPoint<BBandsPoint> {

	private BBandsPoint(IndicatorPeriod period, TimePeriod timePeriod) {
		super(period, timePeriod);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected BBandsPoint thisPoint() {
		return this;
	}

	@Override
	public BBandsPoint generateNext() {
		// TODO Auto-generated method stub
		return null;
	}

}
