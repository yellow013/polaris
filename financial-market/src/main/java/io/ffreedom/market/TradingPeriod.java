package io.ffreedom.market;

import java.time.LocalTime;

public final class TradingPeriod implements Comparable<TradingPeriod> {

	private int number;
	private LocalTime startTime;
	private LocalTime endTime;
	private boolean isCrossDay = false;

	public static TradingPeriod of(int number, LocalTime startTime, LocalTime endTime) {
		return new TradingPeriod(number, startTime, endTime);
	}

	private TradingPeriod(int number, LocalTime startTime, LocalTime endTime) {
		this.number = number;
		this.startTime = startTime;
		this.endTime = endTime;
		if (endTime.isBefore(startTime)) {
			isCrossDay = true;
		}
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

	// TODO 增加1到3秒的时间偏移量
	public boolean inTimeRange(LocalTime time) {
		if (!isCrossDay) {
			if (time.isAfter(startTime) && time.isBefore(endTime)) {
				return true;
			} else if (startTime.equals(time)) {
				return true;
			} else if (endTime.equals(time)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		TradingPeriod of = TradingPeriod.of(0, LocalTime.of(21, 00, 00), LocalTime.of(01, 00, 00));

		System.out.println(of.inTimeRange(LocalTime.of(23, 00, 00)));

	}

}
