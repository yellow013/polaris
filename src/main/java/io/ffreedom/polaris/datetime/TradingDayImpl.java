package io.ffreedom.polaris.datetime;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class TradingDayImpl implements TradingDay {

	private AtomicReference<LocalDate> current = new AtomicReference<>(LocalDate.now());

	public final static TradingDay INSTANCE = new TradingDayImpl();

	@Override
	public LocalDate current() {
		return current.get();
	}

}
