package io.ffreedom.polaris.datetime;

import java.time.LocalDateTime;

import io.ffreedom.common.datetime.TimeZones;
import io.ffreedom.common.sequence.Serial;

public final class TimePeriod implements Serial<TimePeriod> {

	private long epochTime;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public static TimePeriod with(LocalDateTime startTime, LocalDateTime endTime) {
		if (startTime == null || endTime == null)
			throw new IllegalArgumentException("startTime and endTime cannot null");
		return new TimePeriod(startTime, endTime);
	}

	public TimePeriod(LocalDateTime startTime, LocalDateTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		setEpochTime();
	}

	private void setEpochTime() {
		this.epochTime = startTime.toEpochSecond(TimeZones.UTC);
	}

	@Override
	public long getSerialNumber() {
		return epochTime;
	}

	public long getEpochTime() {
		return epochTime;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

}
