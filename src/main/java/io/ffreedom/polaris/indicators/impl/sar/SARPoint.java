package io.ffreedom.polaris.indicators.impl.sar;

import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;
import io.ffreedom.polaris.indicators.api.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class SARPoint extends TimePeriodPoint<SARPoint> {

	private double pointValue;

	public SARPoint(TradingDay tradingDay, LocalDateTime startTime, LocalDateTime endTime) {
		super(tradingDay, startTime, endTime);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected SARPoint thisPoint() {
		return this;
	}

	public double getPointValue() {
		return pointValue;
	}

}
