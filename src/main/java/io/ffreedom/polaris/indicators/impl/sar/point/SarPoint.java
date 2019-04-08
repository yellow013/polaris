package io.ffreedom.polaris.indicators.impl.sar.point;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class SARPoint extends TimePeriodPoint<SARPoint> {

	public SARPoint(int index,IndicatorPeriod period, TimePeriod timePeriod) {
		super(index, period, timePeriod);
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

	@Override
	public SARPoint generateNext() {
		// TODO Auto-generated method stub
		return null;
	}

}