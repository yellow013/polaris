package io.ffreedom.polaris.datetime.tradingday.impl;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.concurrent.ThreadSafe;

import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;

@ThreadSafe
public class CommonTradingDayImpl implements TradingDay {

	private AtomicReference<LocalDate> current = new AtomicReference<>(LocalDate.now());

	public final static TradingDay INSTANCE = new CommonTradingDayImpl();

	private CommonTradingDayImpl() {
	}

	@Override
	public LocalDate current() {
		return current.get();
	}

	@Override
	public TradingDay set(LocalDate date) {
		current.set(date);
		return this;
	}

}
