package io.polaris.financial.instrument;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.polaris.financial.time.TradingPeriod;

public interface Symbol {

	int id();
	
	String code();

	ImmutableSortedSet<TradingPeriod> tradingPeriodSet();

	Exchange exchange();

}
