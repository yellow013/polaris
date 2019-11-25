package io.polaris.financial;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.polaris.datetime.TradingPeriod;

public interface Symbol {

	int getSymbolId();
	
	String getSymbolName();

	ImmutableSortedSet<TradingPeriod> getTradingPeriodSet();

	Exchange getExchange();

}
