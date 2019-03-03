package io.ffreedom.polaris.indicators.impl.bbands;

import java.time.LocalDateTime;

import io.ffreedom.polaris.indicators.api.TimeSeriesPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class BBandsPoint extends TimeSeriesPoint<BBandsPoint>{

	public BBandsPoint(LocalDateTime startTime, LocalDateTime endTime) {
		super(startTime, endTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected BBandsPoint thisObj() {
		// TODO Auto-generated method stub
		return this;
	}

}
