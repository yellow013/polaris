package io.ffreedom.polaris.financial.futures;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.concurrent.ThreadSafe;

import io.ffreedom.polaris.datetime.TradingDay;

@ThreadSafe
public final class ChinaFuturesTradingDay implements TradingDay {

	@Override
	public LocalDate current() {
		return current.get();
	}

	private static final LocalTime TRADING_DAY_DIVIDING_LINE = LocalTime.of(17, 00);

	private AtomicReference<LocalDate> current = new AtomicReference<>(analysisTradingDay(LocalDateTime.now()));

	public final static TradingDay INSTANCE = new ChinaFuturesTradingDay();

	public static LocalDate analysisTradingDay(LocalDateTime dateTime) {
		DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
		// 判断是否是夜盘
		if (isNightTrading(dateTime.toLocalTime())) {
			// 判断是否周五,是加3天,否则加1天.
			if (dayOfWeek.equals(DayOfWeek.FRIDAY))
				return dateTime.plusDays(3).toLocalDate();
			else
				return dateTime.plusDays(1).toLocalDate();
		} else {
			// 判断是否周六,是加2天,否则不加.
			if (dayOfWeek.equals(DayOfWeek.SATURDAY))
				return dateTime.plusDays(2).toLocalDate();
			else
				return dateTime.toLocalDate();
		}
	}

	private static boolean isNightTrading(LocalTime time) {
		if (time.isAfter(TRADING_DAY_DIVIDING_LINE))
			return true;
		else
			return false;
	}

}
