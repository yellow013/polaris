package io.ffreedom.polaris.indicators.impl;

import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;

public abstract class TimePeriodPoint<Y extends TimePeriodPoint<Y>> extends AbstractPoint<TimePeriod, Y> {

	protected IndicatorTimePeriod period;
	protected TimePeriod timePeriod;

	protected TimePeriodPoint(int index, Instrument instrument, IndicatorTimePeriod period, TimePeriod timePeriod) {
		super(index, instrument);
		this.period = period;
		this.timePeriod = timePeriod;
	}

	public IndicatorTimePeriod getPeriod() {
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