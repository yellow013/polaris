package io.ffreedom.indicators.impl.sar;

import java.time.LocalDateTime;

import io.ffreedom.indicators.api.TimeSeriesPoint;
import io.ffreedom.market.MarketData;

@SuppressWarnings("unused")
public class SARPoint implements TimeSeriesPoint<SARPoint, LocalDateTime, Double, MarketData> {

	private LocalDateTime xAxis;
	private Double yAxis;

	@Override
	public LocalDateTime getXAxis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getYAxis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SARPoint onTick(MarketData tick) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(SARPoint o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
