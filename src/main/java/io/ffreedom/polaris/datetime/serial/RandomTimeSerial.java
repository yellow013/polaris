package io.ffreedom.polaris.datetime.serial;

import java.time.LocalDateTime;

import io.ffreedom.common.datetime.EpochTime;
import io.ffreedom.common.datetime.TimeZones;
import io.ffreedom.common.sequence.Serial;

public final class RandomTimeSerial implements Serial<RandomTimeSerial> {

	private LocalDateTime timePoint;
	private long epochMillis;
	private long repeat;
	private long serialNumber;

	public static RandomTimeSerial with(LocalDateTime dateTime) {
		if (dateTime == null)
			throw new IllegalArgumentException("dateTime cannot null");
		return new RandomTimeSerial(dateTime, 0);
	}

	public static RandomTimeSerial with(RandomTimeSerial other) {
		if (other == null)
			throw new IllegalArgumentException("other RandomTimeSerial cannot null");
		return new RandomTimeSerial(other.timePoint, other.repeat + 1);
	}

	private RandomTimeSerial(LocalDateTime startTime, long repeat) {
		this.timePoint = startTime;
		this.repeat = repeat;
		setEpochMillis();
		setSerialNumber();
	}

	private void setEpochMillis() {
		this.epochMillis = EpochTime.milliseconds(timePoint, TimeZones.DEFAULT_ZONE_OFFSET);
	}

	public void setSerialNumber() {
		this.serialNumber = epochMillis * 1000L + repeat;
	}

	@Override
	public long getSerialNumber() {
		return serialNumber;
	}

	public LocalDateTime getTimePoint() {
		return timePoint;
	}

	public long getEpochMillis() {
		return epochMillis;
	}

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();

		long epochSecond = now.toEpochSecond(TimeZones.DEFAULT_ZONE_OFFSET);
		System.out.println(epochSecond);

		RandomTimeSerial timeStarted0 = RandomTimeSerial.with(now);
		System.out.println(timeStarted0.getTimePoint());
		System.out.println(timeStarted0.getEpochMillis());
		System.out.println(timeStarted0.getSerialNumber());

		RandomTimeSerial timeStarted1 = RandomTimeSerial.with(timeStarted0);
		System.out.println(timeStarted1.getTimePoint());
		System.out.println(timeStarted1.getEpochMillis());
		System.out.println(timeStarted1.getSerialNumber());

		System.out.println(EpochTime.milliseconds());
		System.out.println(EpochTime.seconds());
		System.out.println(Long.MAX_VALUE);
	}

}
