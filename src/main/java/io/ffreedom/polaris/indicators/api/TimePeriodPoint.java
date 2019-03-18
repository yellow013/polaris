package io.ffreedom.polaris.indicators.api;

import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;

public abstract class TimePeriodPoint<Y extends TimePeriodPoint<Y>> implements Point<TimePeriod, Y>, Comparable<Y> {

	private TradingDay tradingDay;
	private TimePeriod timePeriod;

	public TimePeriodPoint(TradingDay tradingDay, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.timePeriod = TimePeriod.with(startTime, endTime);
	}

	@Override
	public final TimePeriod getXAxis() {
		return timePeriod;
	}

	@Override
	public final Y getYAxis() {
		return thisPoint();
	}

	@Override
	public final int compareTo(Y o) {
		return getXAxis().compareTo(o.getXAxis());
	}

	public TradingDay getTradingDay() {
		return tradingDay;
	}

	public boolean isPeriod(LocalDateTime time) {
		return timePeriod.getStartTime().isBefore(time) && timePeriod.getEndTime().isAfter(time) ? true : false;
	}

	public LocalDateTime getStartTime() {
		return timePeriod.getStartTime();
	}

	public LocalDateTime getEndTime() {
		return timePeriod.getEndTime();
	}

	protected abstract Y thisPoint();

}