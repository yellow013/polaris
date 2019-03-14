package io.ffreedom.polaris.indicators.api;

import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;

public abstract class TimeSeriesPoint<Y extends TimeSeriesPoint<Y>> implements Point<LocalDateTime, Y>, Comparable<Y> {

	private TradingDay tradingDay;

	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public TimeSeriesPoint(TradingDay tradingDay, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public final LocalDateTime getXAxis() {
		return startTime;
	}

	@Override
	public final Y getYAxis() {
		return thisObj();
	}

	@Override
	public final int compareTo(Y o) {
		return getXAxis().compareTo(o.getXAxis());
	}

	public TradingDay getTradingDay() {
		return tradingDay;
	}

	public boolean isPeriod(LocalDateTime time) {
		return startTime.isBefore(time) && endTime.isAfter(time) ? true : false;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	protected abstract Y thisObj();

}