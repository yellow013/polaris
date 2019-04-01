package io.ffreedom.polaris.datetime.tradingday.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.annotation.concurrent.ThreadSafe;

import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;

@Deprecated
@ThreadSafe
public class CommonTradingDayImpl implements TradingDay {

	public final static CommonTradingDayImpl CURRENT = CommonTradingDayImpl.with(LocalDateTime.now());

	private LocalDate date;

	private CommonTradingDayImpl(LocalDate date) {
		this.date = date;
	}

	public static CommonTradingDayImpl with(LocalDateTime dateTime) {
		return new CommonTradingDayImpl(dateTime.toLocalDate());
	}

	public static CommonTradingDayImpl with(LocalDate date) {
		return new CommonTradingDayImpl(date);
	}

	@Override
	public LocalDate getDate() {
		return date;
	}

}
