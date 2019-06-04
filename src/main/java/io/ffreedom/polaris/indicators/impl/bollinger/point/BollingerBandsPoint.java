package io.ffreedom.polaris.indicators.impl.bollinger.point;

import io.ffreedom.polaris.datetime.XTimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class BollingerBandsPoint extends TimePeriodPoint<BollingerBandsPoint> {

	private BollingerBandsPoint(int index, Instrument instrument, IndicatorTimePeriod period, XTimePeriod timePeriod) {
		super(index, instrument, period, timePeriod);
	}

	@Override
	protected BollingerBandsPoint thisObj() {
		return this;
	}

	@Override
	public BollingerBandsPoint generateNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
