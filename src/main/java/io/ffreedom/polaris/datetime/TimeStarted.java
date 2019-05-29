package io.ffreedom.polaris.datetime;

import java.time.LocalDateTime;

import io.ffreedom.common.datetime.EpochTime;
import io.ffreedom.common.datetime.TimeZones;
import io.ffreedom.common.sequence.Serial;

public class TimeStarted implements Serial<TimeStarted> {

	private LocalDateTime startTime;
	private long epochMillis;

	public static TimeStarted with(LocalDateTime startTime) {
		if (startTime == null)
			throw new IllegalArgumentException("startTime cannot null");
		return new TimeStarted(startTime);
	}

	private TimeStarted(LocalDateTime startTime) {
		this.startTime = startTime;
		setEpochMillis();
	}

	private void setEpochMillis() {
		this.epochMillis = EpochTime.milliseconds(startTime, TimeZones.DEFAULT_ZONE_OFFSET);
	}

	@Override
	public long getSerialNumber() {
		return epochMillis;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public long getEpochMillis() {
		return epochMillis;
	}

}
