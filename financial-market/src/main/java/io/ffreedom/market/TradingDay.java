package io.ffreedom.market;

import java.time.LocalDate;

public final class TradingDay {

	private static LocalDate TRADING_DAY;

	public static LocalDate get() {
		return TRADING_DAY;
	}

	public static void set(LocalDate tradingDay) {
		TRADING_DAY = tradingDay;
	}

}
