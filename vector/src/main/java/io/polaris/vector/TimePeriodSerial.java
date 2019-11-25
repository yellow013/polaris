package io.polaris.vector;

import java.time.LocalDateTime;

import io.ffreedom.common.datetime.TimeZones;
import io.ffreedom.common.sequence.Serial;

public final class TimePeriodSerial implements Serial<TimePeriodSerial> {

	private long epochTime;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public static TimePeriodSerial with(LocalDateTime startTime, LocalDateTime endTime) {
		if (startTime == null)
			throw new IllegalArgumentException("startTime cannot null");
		if (endTime == null)
			throw new IllegalArgumentException("endTime cannot null");
		return new TimePeriodSerial(startTime, endTime);
	}

	private TimePeriodSerial(LocalDateTime startTime, LocalDateTime endTime) {
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

	public boolean isPeriod(LocalDateTime time) {
		return startTime.isBefore(time) && endTime.isAfter(time) ? true : false;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

}
