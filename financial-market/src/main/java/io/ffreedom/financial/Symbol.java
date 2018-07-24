package io.ffreedom.financial;

import io.ffreedom.market.TradingPeriodSet;

public interface Symbol {

	int getSymbolId();
	
	String getSymbolCode();

	TradingPeriodSet getTradingPeriodSet();

	Exchange getExchange();

}
