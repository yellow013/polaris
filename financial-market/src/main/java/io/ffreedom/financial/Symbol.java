package io.ffreedom.financial;

import io.ffreedom.market.data.TradingPeriodSet;
import io.ffreedom.market.role.Exchange;

public interface Symbol {

	int getSymbolId();
	
	String getSymbolCode();

	TradingPeriodSet getTradingPeriodSet();

	Exchange getExchange();

}
