package io.ffreedom.indicators.impl.sar;

import java.time.LocalDateTime;

import io.ffreedom.indicators.api.TimeSeriesPoint;
import io.ffreedom.market.data.MarketData;

public class SARPoint extends TimeSeriesPoint<SARPoint> {

	private double pointPrice;

	public SARPoint(LocalDateTime startDateTime) {
		super(startDateTime);
	}

	@Override
	public void onMarketData(MarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected SARPoint getInstance() {
		return this;
	}

	public double getPointPrice() {
		return pointPrice;
	}

}
