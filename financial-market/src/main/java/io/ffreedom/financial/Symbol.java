package io.ffreedom.financial;

import io.ffreedom.market.data.TradingPeriodSet;
import io.ffreedom.market.role.Exchange;

public interface Symbol {

	String getSymbolName();

	TradingPeriodSet getTradingPeriodSet();

	Exchange getExchange();

}
