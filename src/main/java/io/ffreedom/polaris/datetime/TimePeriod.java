package io.ffreedom.polaris.datetime;

import java.time.LocalDateTime;

import io.ffreedom.common.datetime.TimeZones;
import io.ffreedom.common.sequence.Serial;

public final class TimePeriod implements Serial<TimePeriod> {

	private long serialNumber;
	private long epochTime;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public static TimePeriod with(LocalDateTime startTime, LocalDateTime endTime) {
		return new TimePeriod(startTime, endTime);
	}

	public TimePeriod(LocalDateTime startTime, LocalDateTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		init();
	}

	private void init() {
		this.epochTime = getStartTime().toEpochSecond(TimeZones.UTC);
		this.serialNumber = epochTime ;
	}

	@Override
	public long getSerialNumber() {
		return serialNumber;
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
