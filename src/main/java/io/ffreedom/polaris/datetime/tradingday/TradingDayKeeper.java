package io.ffreedom.polaris.datetime.tradingday;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;
import io.ffreedom.polaris.datetime.tradingday.impl.ChinaFuturesTradingDayImpl;
import io.ffreedom.polaris.datetime.tradingday.impl.CommonTradingDayImpl;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.financial.Symbol;
import io.ffreedom.polaris.financial.futures.ChinaFutures;
import io.ffreedom.polaris.financial.futures.ChinaFuturesSymbol;

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
