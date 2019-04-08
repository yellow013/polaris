package io.ffreedom.polaris.indicators.impl.sar.point;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class SarPoint extends TimePeriodPoint<SarPoint> {

	public SarPoint(int index, Instrument instrument, IndicatorPeriod period, TimePeriod timePeriod) {
		super(index, instrument, period, timePeriod);
		// TODO Auto-generated constructor stub
	}

	private double pointValue;

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected SarPoint thisPoint() {
		return this;
	}

	public double getPointValue() {
		return pointValue;
	}

	@Override
	public SarPoint generateNext() {
		// TODO Auto-generated method stub
		return null;
	}

}
