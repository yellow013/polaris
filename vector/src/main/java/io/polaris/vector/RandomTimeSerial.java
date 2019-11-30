package io.polaris.vector;

import java.time.LocalDateTime;

import io.mercury.common.datetime.EpochTime;
import io.mercury.common.datetime.TimeZones;
import io.mercury.common.sequence.Serial;

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
		return new RandomTimeSerial(other.timePoint, other.repeat++);
	}

	private RandomTimeSerial(LocalDateTime startTime, long repeat) {
		this.timePoint = startTime;
		this.repeat = repeat;
		setEpochMillis();
		setSerialNumber();
	}

	private void setEpochMillis() {
		this.epochMillis = EpochTime.milliseconds(timePoint, TimeZones.SYSTEM_DEFAULT_OFFSET);
	}

	public void setSerialNumber() {
		this.serialNumber = epochMillis * 1000L + repeat;
	}

	@Override
	public long serialNumber() {
		return serialNumber;
	}

	public LocalDateTime timePoint() {
		return timePoint;
	}

	public long epochMillis() {
		return epochMillis;
	}

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();

		long epochSecond = now.toEpochSecond(TimeZones.SYSTEM_DEFAULT_OFFSET);
		System.out.println(epochSecond);

		RandomTimeSerial timeStarted0 = RandomTimeSerial.with(now);
		System.out.println(timeStarted0.timePoint());
		System.out.println(timeStarted0.epochMillis());
		System.out.println(timeStarted0.serialNumber());

		RandomTimeSerial timeStarted1 = RandomTimeSerial.with(timeStarted0);
		System.out.println(timeStarted1.timePoint());
		System.out.println(timeStarted1.epochMillis());
		System.out.println(timeStarted1.serialNumber());

		System.out.println(EpochTime.milliseconds());
		System.out.println(EpochTime.seconds());
		System.out.println(Long.MAX_VALUE);
	}

}
