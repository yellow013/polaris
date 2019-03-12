package io.ffreedom.polaris.datetime.tradingday.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface TradingDay {

	LocalDate current();

	TradingDay set(LocalDateTime datetime);

}