package io.ffreedom.polaris.indicators.base;

import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.XTimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;

public abstract class TimePeriodPoint<Y extends TimePeriodPoint<Y>> extends AbstractPoint<XTimePeriod, Y> {

	protected IndicatorTimePeriod period;
	protected XTimePeriod timePeriod;

	protected TimePeriodPoint(int index, Instrument instrument, IndicatorTimePeriod period, XTimePeriod timePeriod) {
		super(index, instrument);
		this.period = period;
		this.timePeriod = timePeriod;
	}

	public IndicatorTimePeriod getPeriod() {
		return period;
	}

	@Override
	public XTimePeriod getXAxis() {
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