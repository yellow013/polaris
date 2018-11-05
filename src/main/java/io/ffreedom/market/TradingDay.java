package io.ffreedom.market;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class TradingDay {

	private static AtomicReference<LocalDate> CURRENT_TRADING_DAY = new AtomicReference<>(LocalDate.now());

	public static LocalDate currentTradingDay() {
		return CURRENT_TRADING_DAY.get();
	}

	public static void setTradingDay(LocalDate tradingDay) {
		CURRENT_TRADING_DAY.set(tradingDay);
	}

}
