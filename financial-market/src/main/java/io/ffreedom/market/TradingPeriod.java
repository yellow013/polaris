package io.ffreedom.market;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

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
			return (startSecondOfDay <= secondOfDay && endSecondOfDay >= secondOfDay) ? true : false;
		} else {
			return (startSecondOfDay <= secondOfDay || endSecondOfDay >= secondOfDay) ? true : false;
		}
	}

	public MutableList<TimeTwin> segmentByDuration(LocalDate tradingDay, Duration segmentationDuration) {
		//获取分割参数的秒数
		int seconds = (int) segmentationDuration.getSeconds();
		//判断分割段是否大于半天
		if (seconds > TimeConstants.DAY_SECONDS_HALF) {
			//如果交易周期跨天,则此分割周期等于当天开始时间至次日结束时间
			//如果交易周期未跨天,则此分割周期等于当天开始时间至当天结束时间
			return FastList.newListWith(isCrossDay
					? TimeTwin.of(tradingDay, serialNumber, LocalDateTime.of(SysDate.getNow(), startTime),
							LocalDateTime.of(SysDate.getTomorrow(), endTime))
					: TimeTwin.of(tradingDay, serialNumber, LocalDateTime.of(SysDate.getNow(), startTime),
							LocalDateTime.of(SysDate.getNow(), endTime)));
		} else {
			//获取此交易时间段的总时长
			int totalSeconds = (int) totalDuration.getSeconds();
			//计算按照分割参数总的段数
			int count = totalSeconds / seconds;
			if (totalSeconds % seconds > 0) {
				count++;
			}
			FastList<TimeTwin> list = FastList.newList(count);
			//计算开始时间点
			LocalDateTime startPoint = LocalDateTime.of(SysDate.getNow(), startTime);
			//计算结束时间点,如果跨天则日期加一天
			LocalDateTime lastEndPoint = LocalDateTime.of(isCrossDay ? SysDate.getTomorrow() : SysDate.getNow(),
					endTime);
			for (int i = 0; i < count; i++) {
				LocalDateTime nextStartPoint = startPoint.plusSeconds(seconds);
				if (nextStartPoint.isBefore(lastEndPoint)) {
					LocalDateTime endPoint = nextStartPoint.minusNanos(1);
					list.add(TimeTwin.of(tradingDay, serialNumber, startPoint, endPoint));
				} else {
					list.add(TimeTwin.of(tradingDay, serialNumber, startPoint, lastEndPoint));
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

		tradingPeriod.segmentByDuration(LocalDate.of(2018, Month.JUNE, 20), Duration.ofMinutes(45)).each(timeTwin -> {
			System.out.println(timeTwin.getStartDateTime() + " - " + timeTwin.getEndDateTime());
		});

		LocalDateTime of = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 55, 30));

		System.out.println(of);

		System.out.println(of.plusMinutes(30));

	}

}
