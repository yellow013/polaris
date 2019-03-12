package io.ffreedom.polaris.datetime.tradingday;

import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;
import io.ffreedom.polaris.datetime.tradingday.impl.ChinaFuturesTradingDayImpl;
import io.ffreedom.polaris.datetime.tradingday.impl.CommonTradingDayImpl;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.financial.Symbol;
import io.ffreedom.polaris.financial.futures.ChinaFutures;
import io.ffreedom.polaris.financial.futures.ChinaFuturesSymbol;

public final class TradingDayKeeper {

	public static TradingDay get(Instrument instrument) {
		if (instrument instanceof ChinaFutures)
			return ChinaFuturesTradingDayImpl.INSTANCE;
		else
			return CommonTradingDayImpl.INSTANCE;
	}

	public static TradingDay get(Symbol symbol) {
		if (symbol instanceof ChinaFuturesSymbol)
			return ChinaFuturesTradingDayImpl.INSTANCE;
		else
			return CommonTradingDayImpl.INSTANCE;
	}

	public static void main(String[] args) {

	}

}
