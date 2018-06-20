package io.ffreedom.market.data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.FastList;

import io.ffreedom.common.datetime.SysDate;
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
	public boolean isPeriod(LocalTime time) {
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
			return FastList.newWithNValues(1,
					() -> isCrossDay
							? TimeTwin.of(LocalDateTime.of(SysDate.getNow(), startTime),
									LocalDateTime.of(SysDate.getTomorrow(), endTime))
							: TimeTwin.of(LocalDateTime.of(SysDate.getNow(), startTime),
									LocalDateTime.of(SysDate.getNow(), endTime)));
		} else {
			int totalSeconds = (int) totalDuration.getSeconds();
			int count = totalSeconds / seconds;
			if (totalSeconds % seconds > 0) {
				count++;
			}
			FastList<TimeTwin> list = FastList.newList(count);
			LocalDateTime startPoint = LocalDateTime.of(SysDate.getNow(), startTime);
			LocalDateTime lastEndPoint = LocalDateTime.of(isCrossDay ? SysDate.getTomorrow() : SysDate.getNow(),
					endTime);
			for (int i = 0; i < count; i++) {
				LocalDateTime nextStartPoint = startPoint.plusSeconds(seconds);
				if (nextStartPoint.isBefore(lastEndPoint)) {
					LocalDateTime endPoint = nextStartPoint.minusNanos(1);
					list.add(TimeTwin.of(startPoint, endPoint));
				} else {
					list.add(TimeTwin.of(startPoint, lastEndPoint));
					break;
				}
				startPoint = nextStartPoint;
			}
			return list;
		}
	}

	public static void main(String[] args) {

		TradingPeriod tradingPeriod = TradingPeriod.with(0, LocalTime.of(21, 00, 00), LocalTime.of(2, 30, 00));

		System.out.println(tradingPeriod.isPeriod(LocalTime.of(14, 00, 00)));

		tradingPeriod.segmentByDuration(Duration.ofMinutes(45)).each(timeTwin -> {
			System.out.println(timeTwin.getStartDateTime() + " - " + timeTwin.getEndDateTime());
		});

		// System.out.println(LocalTime.of(23, 50, 50).plusMinutes(20));

		LocalDateTime of = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 55, 30));

		System.out.println(of);

		System.out.println(of.plusMinutes(30));

	}

}
