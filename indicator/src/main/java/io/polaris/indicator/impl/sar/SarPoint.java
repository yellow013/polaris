package io.polaris.indicators.impl.sar;

import io.polaris.datetime.serial.TimePeriodSerial;
import io.polaris.financial.Instrument;
import io.polaris.indicators.api.IndicatorTimePeriod;
import io.polaris.indicators.base.TimePeriodPoint;
import io.polaris.market.impl.BasicMarketData;

public final class SarPoint extends TimePeriodPoint<SarPoint> {

	private double pointValue;

	public SarPoint(int index, Instrument instrument, IndicatorTimePeriod period, TimePeriodSerial timePeriod) {
		super(index, instrument, period, timePeriod);
		// TODO Auto-generated constructor stub
	}

	public double getPointValue() {
		return pointValue;
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
