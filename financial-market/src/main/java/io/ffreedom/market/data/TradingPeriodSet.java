package io.ffreedom.market.data;

import java.time.LocalTime;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.impl.set.sorted.immutable.ImmutableSortedSetFactoryImpl;

public final class TradingPeriodSet {

	private ImmutableSortedSet<TradingPeriod> immutableTradingPeriodSet;

	private TradingPeriodSet(TradingPeriod[] tradingPeriods) {
		this.immutableTradingPeriodSet = ImmutableSortedSetFactoryImpl.INSTANCE.with(tradingPeriods);
	}

	public static TradingPeriodSet with(TradingPeriod... tradingPeriods) {
		return new TradingPeriodSet(tradingPeriods);
	}

	public ImmutableSortedSet<TradingPeriod> getImmutableTradingPeriodSet() {
		return immutableTradingPeriodSet;
	}

	public boolean isPeriod(LocalTime time) {
		for (TradingPeriod tradingPeriod : immutableTradingPeriodSet) {
			if (tradingPeriod.isPeriod(time)) {
				return true;
			}
		}
		return false;
	}

}
