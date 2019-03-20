package io.ffreedom.polaris.datetime.tradingday.api;

import java.time.LocalDate;

public interface TradingDay extends Comparable<TradingDay> {

	LocalDate getDate();

	@Override
	default int compareTo(TradingDay o) {
		return getDate().compareTo(o.getDate());
	}

}