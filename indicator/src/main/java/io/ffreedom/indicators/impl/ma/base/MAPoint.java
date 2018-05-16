package io.ffreedom.indicators.impl.ma.base;

import java.time.LocalDateTime;

import io.ffreedom.indicators.api.TimeSeriesPoint;
import io.ffreedom.market.data.MarketData;

public class MAPoint implements TimeSeriesPoint<MAPoint, LocalDateTime, Double, MarketData> {

	private LocalDateTime xAxis;
	private Double yAxis;

	public MAPoint(LocalDateTime xAxis, Double yAxis) {
		super();
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}

	@Override
	public LocalDateTime getXAxis() {
		return xAxis;
	}

	@Override
	public Double getYAxis() {
		return yAxis;
	}

	@Override
	public MAPoint onTick(MarketData tick) {
		return null;
	}

	@Override
	public int compareTo(MAPoint o) {
		return this.xAxis.isBefore(o.xAxis) ? -1 : this.xAxis.isAfter(o.xAxis) ? 1 : 0;
	}
	
	
}
