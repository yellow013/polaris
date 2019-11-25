package io.polaris.indicators.impl.bollinger;

import io.polaris.datetime.serial.TimePeriodSerial;
import io.polaris.financial.Instrument;
import io.polaris.indicators.api.IndicatorTimePeriod;
import io.polaris.indicators.base.TimePeriodPoint;
import io.polaris.market.impl.BasicMarketData;

public final class BollingerBandsPoint extends TimePeriodPoint<BollingerBandsPoint> {

	private BollingerBandsPoint(int index, Instrument instrument, IndicatorTimePeriod period, TimePeriodSerial timePeriod) {
		super(index, instrument, period, timePeriod);
	}



	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
