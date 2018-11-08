package io.ffreedom.market;

import io.ffreedom.financial.Instrument;
import io.ffreedom.financial.Symbol;
import io.ffreedom.financial.futures.ChinaFutures;
import io.ffreedom.financial.futures.ChinaFuturesSymbol;
import io.ffreedom.financial.futures.ChinaFuturesTradingDay;

public final class TradingDayKeeper {

	public static TradingDay getInstance(Instrument instrument) {
		if (instrument instanceof ChinaFutures) {
			return ChinaFuturesTradingDay.INSTANCE;
		} else {
			// TODO fill instance
			return null;
		}
	}

	public static TradingDay getInstance(Symbol symbol) {
		if (symbol instanceof ChinaFuturesSymbol) {
			return ChinaFuturesTradingDay.INSTANCE;
		} else {
			// TODO fill instance
			return null;
		}
	}

}
