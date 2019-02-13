package io.ffreedom.polaris.financial;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.polaris.datetime.TradingPeriod;

public interface Symbol {

	int getSymbolId();
	
	String getSymbolCode();

	ImmutableSortedSet<TradingPeriod> getTradingPeriodSet();

	Exchange getExchange();

}
