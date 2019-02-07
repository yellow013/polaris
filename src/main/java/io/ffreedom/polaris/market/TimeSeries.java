package io.ffreedom.market;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class TimeSeries implements Comparable<TimeSeries> {

	private LocalDate date;
	private LocalTime time;

	public static TimeSeries newInstance(LocalDate date, LocalTime time) {
		return new TimeSeries(date, time);
	}

	private TimeSeries(LocalDate date, LocalTime time) {
		this.date = date;
		this.time = time;
	}

	public LocalDate getLocalDate() {
		return date;
	}

	public LocalTime getLocalTime() {
		return time;
	}

	public LocalDateTime toLocalDateTime() {
		return LocalDateTime.of(date, time);
	}

	@Override
	public int compareTo(TimeSeries o) {
		return date.isBefore(o.date) ? -1
				: date.isAfter(o.date) ? 1 
						: time.isBefore(o.time) ? -1 
								: time.isAfter(o.time) ? 1 
										: 0;
	}

}
