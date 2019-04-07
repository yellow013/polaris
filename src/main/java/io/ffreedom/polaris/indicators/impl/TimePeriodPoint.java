package io.ffreedom.polaris.indicators.impl;

import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;

public abstract class TimePeriodPoint<Y extends TimePeriodPoint<Y>> extends AbstractPoint<TimePeriod, Y> {

	protected IndicatorPeriod period;
	protected TimePeriod timePeriod;

	protected TimePeriodPoint(int index, IndicatorPeriod period, TimePeriod timePeriod) {
		super(index);
		this.period = period;
		this.timePeriod = timePeriod;
	}

	protected TimePeriodPoint(int index, IndicatorPeriod period, LocalDateTime startTime, LocalDateTime endTime) {
		this(index, period, TimePeriod.with(startTime, endTime));
	}

	public IndicatorPeriod getPeriod() {
		return period;
	}

	@Override
	public TimePeriod getXAxis() {
		return timePeriod;
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

}