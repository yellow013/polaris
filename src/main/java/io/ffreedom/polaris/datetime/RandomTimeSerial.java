package io.ffreedom.polaris.datetime;

import java.time.LocalDateTime;

import io.ffreedom.common.datetime.EpochTime;
import io.ffreedom.common.datetime.TimeZones;
import io.ffreedom.common.sequence.Serial;

public final class RandomTimeSerial implements Serial<RandomTimeSerial> {

	private LocalDateTime startTime;
	private long epochMillis;

	public static RandomTimeSerial with(LocalDateTime startTime) {
		if (startTime == null)
			throw new IllegalArgumentException("startTime cannot null");
		return new RandomTimeSerial(startTime);
	}

	private RandomTimeSerial(LocalDateTime startTime) {
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
		RandomTimeSerial timeStarted = RandomTimeSerial.with(now);
		System.out.println(epochSecond);
		System.out.println(timeStarted.getEpochMillis());
		System.out.println(EpochTime.milliseconds());
		System.out.println(EpochTime.seconds());

	}
}
