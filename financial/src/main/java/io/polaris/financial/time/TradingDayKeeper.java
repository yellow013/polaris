package io.polaris.financial.time;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.instrument.Symbol;
import io.polaris.financial.instrument.futures.ChinaFutures;
import io.polaris.financial.instrument.futures.ChinaFuturesSymbol;
import io.polaris.financial.time.tradingday.api.TradingDay;
import io.polaris.financial.time.tradingday.impl.ChinaFuturesTradingDayImpl;
import io.polaris.financial.time.tradingday.impl.CommonTradingDayImpl;

@Deprecated
public final class TradingDayKeeper {

	public static TradingDay get(Instrument instrument) {
		if (instrument instanceof ChinaFutures)
			return ChinaFuturesTradingDayImpl.CURRENT;
		else
			return CommonTradingDayImpl.CURRENT;
	}

	public static TradingDay get(Symbol symbol) {
		if (symbol instanceof ChinaFuturesSymbol)
			return ChinaFuturesTradingDayImpl.CURRENT;
		else
			return CommonTradingDayImpl.CURRENT;
	}

	public static TradingDay get(Instrument instrument, LocalDateTime datetime) {
		if (instrument instanceof ChinaFutures)
			return ChinaFuturesTradingDayImpl.with(datetime);
		else
			return CommonTradingDayImpl.with(datetime);
	}

	public static TradingDay get(Symbol symbol, LocalDateTime datetime) {
		if (symbol instanceof ChinaFuturesSymbol)
			return ChinaFuturesTradingDayImpl.with(datetime);
		else
			return CommonTradingDayImpl.with(datetime);
	}

	public static TradingDay get(Instrument instrument, LocalDate date) {
		if (instrument instanceof ChinaFutures)
			return ChinaFuturesTradingDayImpl.with(date);
		else
			return CommonTradingDayImpl.with(date);
	}

	public static TradingDay get(Symbol symbol, LocalDate date) {
		if (symbol instanceof ChinaFuturesSymbol)
			return ChinaFuturesTradingDayImpl.with(date);
		else
			return CommonTradingDayImpl.with(date);
	}

	public static void main(String[] args) {

	}

}
