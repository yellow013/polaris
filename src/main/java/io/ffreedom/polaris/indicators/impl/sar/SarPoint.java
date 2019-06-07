package io.ffreedom.polaris.indicators.impl.sar;

import io.ffreedom.polaris.datetime.XTimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.TimePeriodPoint;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public class SarPoint extends TimePeriodPoint<SarPoint> {

	private double pointValue;

	public SarPoint(int index, Instrument instrument, IndicatorTimePeriod period, XTimePeriod timePeriod) {
		super(index, instrument, period, timePeriod);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected SarPoint thisObj() {
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

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
