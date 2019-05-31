package io.ffreedom.polaris.datetime;

import java.time.LocalDateTime;

import io.ffreedom.common.datetime.EpochTime;
import io.ffreedom.common.datetime.TimeZones;
import io.ffreedom.common.sequence.Serial;

public final class XRandomTime implements Serial<XRandomTime> {

	private LocalDateTime startTime;
	private long epochMillis;

	public static XRandomTime with(LocalDateTime startTime) {
		if (startTime == null)
			throw new IllegalArgumentException("startTime cannot null");
		return new XRandomTime(startTime);
	}

	private XRandomTime(LocalDateTime startTime) {
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

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();

		long epochSecond = now.toEpochSecond(TimeZones.DEFAULT_ZONE_OFFSET);
		XRandomTime timeStarted = XRandomTime.with(now);
		System.out.println(epochSecond);
		System.out.println(timeStarted.getEpochMillis());
		System.out.println(EpochTime.milliseconds());
		System.out.println(EpochTime.seconds());

	}
}
