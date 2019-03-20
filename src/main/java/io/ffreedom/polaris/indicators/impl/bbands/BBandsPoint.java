package io.ffreedom.polaris.indicators.impl.bbands;

import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class BBandsPoint extends TimePeriodPoint<BBandsPoint> {

	

	public BBandsPoint(IndicatorPeriod period, TimePeriod timePeriod) {
		super(period, timePeriod);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected BBandsPoint thisPoint() {
		return this;
	}

}
