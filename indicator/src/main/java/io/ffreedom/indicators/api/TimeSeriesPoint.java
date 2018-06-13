package io.ffreedom.indicators.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class TimeSeriesPoint<Y extends TimeSeriesPoint<?>> implements Point<LocalDateTime, Y>, Comparable<Y> {

	private LocalDate realDate;

	private LocalDate tradingDay;
	private int serialNumber;

	private LocalTime startTime;
	private LocalTime endTime;

	public TimeSeriesPoint(LocalDate tradingDay, int serialNumber, LocalTime startTime, LocalTime endTime) {
		super();
		this.tradingDay = tradingDay;
		this.serialNumber = serialNumber;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public final LocalDateTime getXAxis() {
		return LocalDateTime.of(realDate, startTime);
	}

	@Override
	public final Y getYAxis() {
		return getThis();
	}

	@Override
	public final int compareTo(Y o) {
		return getXAxis().compareTo(o.getXAxis());
	}

	public LocalDate getRealDate() {
		return realDate;
	}

	public TimeSeriesPoint<Y> setRealDate(LocalDate realDate) {
		this.realDate = realDate;
		return this;
	}

	public LocalDate getTradingDay() {
		return tradingDay;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	protected abstract Y getThis();

}