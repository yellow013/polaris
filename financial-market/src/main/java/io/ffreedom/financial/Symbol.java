package io.ffreedom.financial;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.market.TradingPeriod;

public interface Symbol {

	int getSymbolId();
	
	String getSymbolCode();

	ImmutableSortedSet<TradingPeriod> getTradingPeriodSet();

	Exchange getExchange();

}
