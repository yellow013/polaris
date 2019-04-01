package io.ffreedom.polaris.indicators.api;

import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.TimePeriod;

public abstract class TimePeriodPoint<Y extends TimePeriodPoint<Y>> implements Point<TimePeriod, Y>, Comparable<Y> {

	protected IndicatorPeriod period;
	protected TimePeriod timePeriod;

	protected TimePeriodPoint(IndicatorPeriod period, TimePeriod timePeriod) {
		super();
		this.period = period;
		this.timePeriod = timePeriod;
	}

	protected TimePeriodPoint(IndicatorPeriod period, LocalDateTime startTime, LocalDateTime endTime) {
		this.timePeriod = TimePeriod.with(startTime, endTime);
	}

	@Override
	public IndicatorPeriod getPeriod() {
		return period;
	}

	@Override
	public TimePeriod getXAxis() {
		return timePeriod;
	}

	@Override
	public Y getYAxis() {
		return thisPoint();
	}

	@Override
	public int compareTo(Y o) {
		return getXAxis().compareTo(o.getXAxis());
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