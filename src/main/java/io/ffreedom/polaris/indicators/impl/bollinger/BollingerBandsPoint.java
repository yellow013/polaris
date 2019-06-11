package io.ffreedom.polaris.indicators.impl.bollinger;

import io.ffreedom.polaris.datetime.TimePeriodSerial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.TimePeriodPoint;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public final class BollingerBandsPoint extends TimePeriodPoint<BollingerBandsPoint> {

	private BollingerBandsPoint(int index, Instrument instrument, IndicatorTimePeriod period, TimePeriodSerial timePeriod) {
		super(index, instrument, period, timePeriod);
	}



	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
