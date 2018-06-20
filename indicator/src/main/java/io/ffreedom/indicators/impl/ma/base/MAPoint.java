package io.ffreedom.indicators.impl.ma.base;

import java.time.LocalDateTime;

import org.apache.commons.math3.stat.descriptive.moment.Mean;

import io.ffreedom.indicators.api.TimeSeriesPoint;
import io.ffreedom.market.data.MarketData;

public class MAPoint extends TimeSeriesPoint<MAPoint> {

	private double avgPrice;

	public MAPoint(LocalDateTime startTime, LocalDateTime endTime) {
		super(startTime, endTime);
	}

	@Override
	public void onMarketData(MarketData marketData) {
		double lastPrice = marketData.getLastPrice();

	}

	@Override
	protected MAPoint getThis() {
		return this;
	}

	public static void main(String[] args) {

		Mean mean = new Mean();

		mean.setData(new double[] { 10D, 20D, 40D, 10D, 50, 12.98 });

		System.out.println(mean.evaluate());

	}

}
