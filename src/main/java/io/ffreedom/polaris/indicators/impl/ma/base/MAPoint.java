package io.ffreedom.polaris.indicators.impl.ma.base;

import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;
import io.ffreedom.polaris.indicators.api.TimeSeriesPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class MAPoint extends TimeSeriesPoint<MAPoint> {

	private double avgPrice;

	private MAPoint(TradingDay tradingDay, LocalDateTime startTime, LocalDateTime endTime) {
		super(tradingDay, startTime, endTime);
	}

	public static MAPoint with(TradingDay tradingDay, LocalDateTime startTime, LocalDateTime endTime) {
		return new MAPoint(tradingDay, startTime, endTime);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		double lastPrice = marketData.getLastPrice();
	}

	@Override
	protected MAPoint thisPoint() {
		return this;
	}

	public static void main(String[] args) {

		double d = 1 + 1 + 6 + 10;

		double b = d / 4;

		System.out.println(b);

		double b1 = b + 20;

		System.out.println(b1 / 2);

		System.out.println((1 + 1 + 6 + 10 + 20) / 2);

	}

}
