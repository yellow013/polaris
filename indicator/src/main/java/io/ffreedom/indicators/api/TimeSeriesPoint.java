package io.ffreedom.indicators.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class TimeSeriesPoint<Y extends TimeSeriesPoint<?>> implements Point<LocalDateTime, Y>, Comparable<Y> {

	private LocalDate tradingDay;

	private LocalDate realDate;
	
	private int serialNumber;
	
	private LocalTime startTime;
	private LocalTime endTime;
	

	

	@Override
	public final LocalDateTime getXAxis() {
		return startDateTime;
	}

	@Override
	public final Y getYAxis() {
		return getThis();
	}

	@Override
	public final int compareTo(Y o) {
		return startDateTime.compareTo(o.getXAxis());
	}

	protected abstract Y getThis();

}