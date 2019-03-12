package io.ffreedom.polaris.datetime.tradingday.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.concurrent.ThreadSafe;

import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;

@ThreadSafe
public class TradingDayImpl implements TradingDay {

	private AtomicReference<LocalDate> current = new AtomicReference<>(LocalDate.now());

	public final static TradingDay INSTANCE = new TradingDayImpl();

	private TradingDayImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocalDate current() {
		return current.get();
	}

	@Override
	public TradingDay set(LocalDateTime datetime) {
		current.set(datetime.toLocalDate());
		return this;
	}

}
