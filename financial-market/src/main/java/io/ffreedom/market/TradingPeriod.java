package io.ffreedom.market;

import java.time.LocalTime;

public final class TradingPeriod implements Comparable<TradingPeriod> {

	private int number;
	private LocalTime startTime;
	private LocalTime endTime;

	public TradingPeriod(int number, LocalTime startTime, LocalTime endTime) {
		this.number = number;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getNumber() {
		return number;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	@Override
	public int compareTo(TradingPeriod o) {
		return this.number < o.number ? -1 : this.number > o.number ? 1 : 0;
	}

	public boolean inTimeRange(LocalTime time) {
		if (time.isAfter(startTime) && time.isBefore(endTime)) {
			return true;
		} else if (startTime.equals(time)) {
			return true;
		} else if (endTime.equals(time)) {
			return true;
		} else {
			return false;
		}
	}

}
