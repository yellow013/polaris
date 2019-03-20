package io.ffreedom.polaris.indicators.impl.sar;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class SARPoint extends TimePeriodPoint<SARPoint> {

	public SARPoint(IndicatorPeriod period, TimePeriod timePeriod) {
		super(period, timePeriod);
		// TODO Auto-generated constructor stub
	}

	private double pointValue;

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected SARPoint thisPoint() {
		return this;
	}

	public double getPointValue() {
		return pointValue;
	}

}
