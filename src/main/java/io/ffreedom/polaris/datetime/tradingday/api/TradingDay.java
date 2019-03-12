package io.ffreedom.polaris.datetime.tradingday.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface TradingDay extends Comparable<TradingDay> {

	LocalDate current();

	TradingDay set(LocalDateTime datetime);

	@Override
	default int compareTo(TradingDay o) {
		return current().compareTo(o.current());
	}

}