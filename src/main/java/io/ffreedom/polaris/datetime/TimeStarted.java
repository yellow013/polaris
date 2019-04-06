package io.ffreedom.polaris.datetime;

import java.time.LocalDateTime;

import io.ffreedom.common.datetime.TimeZones;
import io.ffreedom.common.sequence.Serial;

public class TimeStarted implements Serial<TimeStarted> {

	private LocalDateTime startTime;
	private long epochTime;

	public static TimeStarted with(LocalDateTime startTime) {
		if (startTime == null)
			throw new IllegalArgumentException("startTime and endTime cannot null");
		return new TimeStarted(startTime);
	}

	private TimeStarted(LocalDateTime startTime) {
		this.startTime = startTime;
		setEpochTime();
	}

	private void setEpochTime() {
		this.epochTime = startTime.toEpochSecond(TimeZones.UTC);
	}

	@Override
	public long getSerialNumber() {
		return epochTime;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public long getEpochTime() {
		return epochTime;
	}

}
