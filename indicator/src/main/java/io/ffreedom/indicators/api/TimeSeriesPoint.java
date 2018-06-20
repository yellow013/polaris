package io.ffreedom.indicators.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class TimeSeriesPoint<Y extends TimeSeriesPoint<?>> implements Point<LocalDateTime, Y>, Comparable<Y> {

	private LocalDate tradingDay;
	private long serialNumber;

	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public TimeSeriesPoint(LocalDate tradingDay, long serialNumber, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.tradingDay = tradingDay;
		this.serialNumber = serialNumber;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public final LocalDateTime getXAxis() {
		return startTime;
	}

	@Override
	public final Y getYAxis() {
		return getThis();
	}

	@Override
	public final int compareTo(Y o) {
		return getXAxis().compareTo(o.getXAxis());
	}

	public boolean isPeriod(LocalDateTime time) {
		return startTime.toLocalDate().isBefore(time.toLocalDate()) && endTime.toLocalDate().isAfter(time.toLocalDate())
				? isPeriod(time.toLocalTime())
				: false;
	}

	public boolean isPeriod(LocalTime time) {
		return startTime.toLocalTime().isBefore(time) && endTime.toLocalTime().isAfter(time) ? true : false;
	}

	public LocalDate getTradingDay() {
		return tradingDay;
	}

	public long getSerialNumber() {
		return serialNumber;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	protected abstract Y getThis();

}