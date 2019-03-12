package io.ffreedom.polaris.datetime;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.financial.Symbol;
import io.ffreedom.polaris.financial.futures.ChinaFutures;
import io.ffreedom.polaris.financial.futures.ChinaFuturesSymbol;
import io.ffreedom.polaris.financial.futures.ChinaFuturesTradingDay;

public final class TradingDayKeeper {

	public static TradingDay getInstance(Instrument instrument) {
		if (instrument instanceof ChinaFutures)
			return ChinaFuturesTradingDay.INSTANCE;
		else
			return TradingDayImpl.INSTANCE;
	}

	public static TradingDay getInstance(Symbol symbol) {
		if (symbol instanceof ChinaFuturesSymbol)
			return ChinaFuturesTradingDay.INSTANCE;
		else
			return TradingDayImpl.INSTANCE;
	}

	public static void main(String[] args) {

	}

}
