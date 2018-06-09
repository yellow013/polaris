package io.ffreedom.market.data;

import java.time.Duration;
import java.time.LocalTime;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.FastList;

import io.ffreedom.common.datetime.TimeConstants;

public final class TradingPeriod implements Comparable<TradingPeriod> {

	private int serialNumber;
	private LocalTime startTime;
	private int startSecondOfDay;
	private LocalTime endTime;
	private int endSecondOfDay;
	private boolean isCrossDay;
	private Duration totalDuration;

	public static TradingPeriod with(int serialNumber, LocalTime startTime, LocalTime endTime) {
		return new TradingPeriod(serialNumber, startTime, endTime);
	}

	private TradingPeriod(int serialNumber, LocalTime startTime, LocalTime endTime) {
		this.serialNumber = serialNumber;
		this.startTime = startTime;
		this.startSecondOfDay = startTime.toSecondOfDay();
		this.endTime = endTime;
		this.endSecondOfDay = endTime.toSecondOfDay();
		setAttributes();
	}

	private void setAttributes() {
		if (startSecondOfDay > endSecondOfDay) {
			isCrossDay = true;
			totalDuration = Duration.ofSeconds(endSecondOfDay - startSecondOfDay + TimeConstants.DAY_SECONDS);
		} else {
			isCrossDay = false;
			totalDuration = Duration.ofSeconds(endSecondOfDay - startSecondOfDay);
		}
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public int getStartSecondOfDay() {
		return startSecondOfDay;
	}

	public int getEndSecondOfDay() {
		return endSecondOfDay;
	}

	@Override
	public int compareTo(TradingPeriod o) {
		return this.serialNumber < o.serialNumber ? -1 : this.serialNumber > o.serialNumber ? 1 : 0;
	}

	// TODO 增加1到3秒的时间偏移量
	public boolean isTradingTime(LocalTime time) {
		int secondOfDay = time.toSecondOfDay();
		if (!isCrossDay) {
			if (startSecondOfDay <= secondOfDay && endSecondOfDay >= secondOfDay) {
				return true;
			} else {
				return false;
			}
		} else {
			if (startSecondOfDay <= secondOfDay || endSecondOfDay >= secondOfDay) {
				return true;
			} else {
				return false;
			}
		}
	}

	public MutableList<TimeTwin> segmentByDuration(Duration duration) {
		int seconds = (int) duration.getSeconds();
		if (seconds > TimeConstants.DAY_SECONDS_HALF) {
			return FastList.newWithNValues(1, () -> TimeTwin.of(serialNumber, startTime, endTime));
		} else {
			int totalSeconds = (int) totalDuration.getSeconds();
			int count = totalSeconds / seconds;
			if (totalSeconds % seconds > 0) {
				count++;
			}
			FastList<TimeTwin> list = FastList.newList(count);
			int startPoint = startSecondOfDay;
			for (int i = 0; i < count; i++) {
				LocalTime sTime = LocalTime.ofSecondOfDay(startPoint);
				LocalTime nextSTime = sTime.plusSeconds(seconds);
				LocalTime eTime = nextSTime.minusNanos(1);
				startPoint = nextSTime.toSecondOfDay();
				if (isTradingTime(eTime)) {
					list.add(TimeTwin.of(serialNumber, sTime, eTime));
				} else {
					list.add(TimeTwin.of(serialNumber, sTime, endTime));
				}
			}
			return list;
		}
	}

	public static void main(String[] args) {

		TradingPeriod tradingPeriod = TradingPeriod.with(0, LocalTime.of(13, 00, 00), LocalTime.of(4, 20, 00));

		System.out.println(tradingPeriod.isTradingTime(LocalTime.of(2, 00, 00)));

		tradingPeriod.segmentByDuration(Duration.ofSeconds(10)).each(timeTwin -> {
			System.out.println(timeTwin.getStartTime() + " - " + timeTwin.getEndTime());
		});

		// System.out.println(LocalTime.of(23, 50, 50).plusMinutes(20));
	}

}
