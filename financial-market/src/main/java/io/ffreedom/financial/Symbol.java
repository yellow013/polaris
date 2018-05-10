package io.ffreedom.financial;

import io.ffreedom.market.TradingPeriodSet;

public interface Symbol {

	String getSymbolName();

	TradingPeriodSet getTradingPeriodSet();

	Exchange getExchange();

}
