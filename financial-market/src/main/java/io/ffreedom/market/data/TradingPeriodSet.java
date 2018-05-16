package io.ffreedom.market.data;

import java.time.LocalTime;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.impl.set.sorted.immutable.ImmutableSortedSetFactoryImpl;

public final class TradingPeriodSet {

	private ImmutableSortedSet<TradingPeriod> tradingPeriodSet;

	private TradingPeriodSet(TradingPeriod[] tradingPeriods) {
		this.tradingPeriodSet = ImmutableSortedSetFactoryImpl.INSTANCE.of(tradingPeriods);
	}

	public static TradingPeriodSet newInstance(TradingPeriod... tradingPeriods) {
		return new TradingPeriodSet(tradingPeriods);
	}

	public ImmutableSortedSet<TradingPeriod> getTradingPeriodSet() {
		return tradingPeriodSet;
	}

	public boolean isTradingPeriod(LocalTime time) {
		for (TradingPeriod tradingPeriod : tradingPeriodSet) {
			if (tradingPeriod.inTimeRange(time)) {
				return true;
			}
		}
		return false;
	}

}
