package io.ffreedom.polaris.datetime.tradingday.api;

import java.time.LocalDate;

public interface TradingDay extends Comparable<TradingDay> {

	LocalDate current();

	TradingDay set(LocalDate datetime);

	@Override
	default int compareTo(TradingDay o) {
		return current().compareTo(o.current());
	}

}