package io.ffreedom.indicators.impl.ma.base;

import java.time.LocalDateTime;

import org.apache.commons.math3.stat.descriptive.moment.Mean;

import io.ffreedom.indicators.api.TimeSeriesPoint;
import io.ffreedom.market.data.MarketData;

public class MAPoint extends TimeSeriesPoint<MAPoint> {

	private double avgPrice;

	public MAPoint(LocalDateTime startDateTime) {
		super(startDateTime);
	}

	@Override
	public void onMarketData(MarketData marketData) {
		double lastPrice = marketData.getLastPrice();

	}

	@Override
	protected MAPoint getInstance() {
		return this;
	}
	
	public static void main(String[] args) {
		
		Mean mean = new Mean();
		
		mean.
		
	}

}
