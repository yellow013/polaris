package io.polaris.indicator.impl.macd;

import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.market.impl.BasicMarketData;
import io.polaris.indicator.base.TimePeriodPoint;
import io.polaris.vector.TimePeriod;
import io.polaris.vector.TimePeriodSerial;

public final class MacdPoint extends TimePeriodPoint<MacdPoint> {

	private MacdPoint(int index, Instrument instrument, TimePeriod period, TimePeriodSerial timePeriod) {
		super(index, instrument, period, timePeriod);
	}



	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
