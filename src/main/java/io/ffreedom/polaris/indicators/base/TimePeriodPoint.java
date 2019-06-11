package io.ffreedom.polaris.indicators.base;

import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.TimePeriodSerial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;

public abstract class TimePeriodPoint<Y extends TimePeriodPoint<Y>> extends BasePoint<TimePeriodSerial> {

	protected IndicatorTimePeriod period;
	protected TimePeriodSerial serial;

	protected TimePeriodPoint(int index, Instrument instrument, IndicatorTimePeriod period, TimePeriodSerial serial) {
		super(index, instrument);
		this.period = period;
		this.serial = serial;
	}

	public IndicatorTimePeriod getPeriod() {
		return period;
	}

	@Override
	public TimePeriodSerial getSerial() {
		return serial;
	}

	public LocalDateTime getStartTime() {
		return serial.getStartTime();
	}

	public LocalDateTime getEndTime() {
		return serial.getEndTime();
	}

}