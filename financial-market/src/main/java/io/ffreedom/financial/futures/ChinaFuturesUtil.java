package io.ffreedom.financial.futures;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import io.ffreedom.common.utils.StringUtil;

public final class ChinaFuturesUtil {

	private ChinaFuturesUtil() {
	}

	public static final LocalTime TRADING_DAY_DIVIDING_LINE = LocalTime.of(16, 15);

	public static final LocalDate NOW_TRADING_DAY = analysisTradingDay(LocalDateTime.now());

	public static LocalDate analysisTradingDay(LocalDateTime dateTime) {
		DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
		// 判断是否是夜盘
		if (isNightTrading(dateTime.toLocalTime())) {
			// 判断是否周五,是加3天,否则加1天.
			if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
				return dateTime.plusDays(3).toLocalDate();
			} else {
				return dateTime.plusDays(1).toLocalDate();
			}
		} else {
			// 判断是否周六,是加2天,否则不加.
			if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
				return dateTime.plusDays(2).toLocalDate();
			} else {
				return dateTime.toLocalDate();
			}
		}
	}

	private static boolean isNightTrading(LocalTime time) {
		if (time.isAfter(TRADING_DAY_DIVIDING_LINE)) {
			return true;
		} else {
			return false;
		}
	}

	public static String analysisSymbolCode(String instrumentId) {
		if (StringUtil.isNullOrEmpty(instrumentId)) {
			return instrumentId;
		}
		return instrumentId.replaceAll("\\d", "");
	}

}
