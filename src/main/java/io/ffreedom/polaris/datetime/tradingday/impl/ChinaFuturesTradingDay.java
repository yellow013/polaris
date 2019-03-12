package io.ffreedom.polaris.datetime.tradingday.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.concurrent.ThreadSafe;

import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;

/**
 * 在收盘后至15点05分之前启动获得的TradinDay将存在误差
 * 
 * @author yellow013
 *
 */
@ThreadSafe
public final class ChinaFuturesTradingDay implements TradingDay {

	@Override
	public LocalDate current() {
		return current.get();
	}

	private ChinaFuturesTradingDay() {

	}

	private static final LocalTime TRADING_DAY_DIVIDING_LINE = LocalTime.of(15, 10);

	private AtomicReference<LocalDate> current = new AtomicReference<>(analysisTradingDay(LocalDateTime.now()));

	public final static TradingDay INSTANCE = new ChinaFuturesTradingDay();

	public LocalDate analysisTradingDay(LocalDateTime dateTime) {
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

	@Override
	public TradingDay set(LocalDateTime datetime) {
		current.set(analysisTradingDay(datetime));
		return this;
	}
	
	public static void main(String[] args) {
		
		TradingDay tradingDay = ChinaFuturesTradingDay.INSTANCE;
		tradingDay.set(LocalDateTime.of(LocalDate.of(2019, 3, 15), LocalTime.of(15, 20, 40)));
		
		System.out.println(tradingDay.current());
		
	}

}
