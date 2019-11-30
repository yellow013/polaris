package io.polaris.indicator.base;

import java.time.LocalDateTime;

import io.polaris.financial.instrument.Instrument;
import io.polaris.vector.TimePeriod;
import io.polaris.vector.TimePeriodSerial;

public abstract class TimePeriodPoint<Y extends TimePeriodPoint<Y>> extends BasePoint<TimePeriodSerial> {

	protected TimePeriod period;
	protected TimePeriodSerial serial;

	protected TimePeriodPoint(int index, Instrument instrument, TimePeriod period, TimePeriodSerial serial) {
		super(index, instrument);
		this.period = period;
		this.serial = serial;
	}

	public TimePeriod getPeriod() {
		return period;
	}

	@Override
	public TimePeriodSerial serial() {
		return serial;
	}

	public LocalDateTime getStartTime() {
		return serial.getStartTime();
	}

	public LocalDateTime getEndTime() {
		return serial.getEndTime();
	}

}