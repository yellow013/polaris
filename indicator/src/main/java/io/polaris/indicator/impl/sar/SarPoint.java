package io.polaris.indicator.impl.sar;

import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.market.impl.BasicMarketData;
import io.polaris.indicator.base.TimePeriodPoint;
import io.polaris.vector.TimePeriod;
import io.polaris.vector.TimePeriodSerial;

public final class SarPoint extends TimePeriodPoint<SarPoint> {

	private double pointValue;

	public SarPoint(int index, Instrument instrument, TimePeriod period, TimePeriodSerial timePeriod) {
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
