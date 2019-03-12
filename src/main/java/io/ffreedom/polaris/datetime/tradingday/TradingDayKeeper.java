package io.ffreedom.polaris.datetime.tradingday.impl;

import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.financial.Symbol;
import io.ffreedom.polaris.financial.futures.ChinaFutures;
import io.ffreedom.polaris.financial.futures.ChinaFuturesSymbol;

public final class TradingDayKeeper {

	public static TradingDay get(Instrument instrument) {
		if (instrument instanceof ChinaFutures)
			return ChinaFuturesTradingDay.INSTANCE;
		else
			return TradingDayImpl.INSTANCE;
	}

	public static TradingDay get(Symbol symbol) {
		if (symbol instanceof ChinaFuturesSymbol)
			return ChinaFuturesTradingDay.INSTANCE;
		else
			return TradingDayImpl.INSTANCE;
	}

	public static void main(String[] args) {

	}

}
