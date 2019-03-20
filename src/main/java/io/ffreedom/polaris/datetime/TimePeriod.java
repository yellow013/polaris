package io.ffreedom.polaris.indicators.api;

import java.time.LocalDateTime;

public final class TimePeriod implements Comparable<TimePeriod> {

	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public static TimePeriod with(LocalDateTime startTime, LocalDateTime endTime) {
		return new TimePeriod(startTime, endTime);
	}

	public TimePeriod(LocalDateTime startTime, LocalDateTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public int compareTo(TimePeriod o) {
		return startTime.compareTo(o.startTime);
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

}
