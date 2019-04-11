package io.ffreedom.polaris.indicators.impl.bbands.point;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class BollingerBandsPoint extends TimePeriodPoint<BollingerBandsPoint> {

	private BollingerBandsPoint(int index, Instrument instrument, IndicatorPeriod period, TimePeriod timePeriod) {
		super(index, instrument, period, timePeriod);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

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

}
