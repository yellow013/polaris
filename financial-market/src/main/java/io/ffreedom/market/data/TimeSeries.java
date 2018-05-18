package io.ffreedom.market.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class TimeSeries {

	private LocalDate date;
	private LocalTime time;

	public static TimeSeries newInstance(LocalDate date, LocalTime time) {
		return new TimeSeries(date, time);
	}

	public TimeSeries(LocalDate date, LocalTime time) {
		this.date = date;
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getTime() {
		return time;
	}

	public LocalDateTime toLocalDateTime() {
		return LocalDateTime.of(date, time);
	}

}
