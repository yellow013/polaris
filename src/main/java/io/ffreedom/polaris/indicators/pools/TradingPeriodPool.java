package io.ffreedom.polaris.indicators.pools;

import javax.annotation.concurrent.ThreadSafe;

import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.polaris.datetime.TradingPeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.financial.Symbol;

@ThreadSafe
public final class TradingPeriodPool {

	private static final TradingPeriodPool INSTANCE = new TradingPeriodPool();

	private TradingPeriodPool() {
	}

	// Map<IndicatorPeriod, Map<Symbol, Set<TimePeriod>>>
	private MutableIntObjectMap<ImmutableSortedSet<TradingPeriod>> tradingPeriodMap = ECollections
			.newIntObjectHashMap();

	// Map<IndicatorPeriod, Map<Symbol, Map<SerialNumber, TimePeriod>>>
	private ImmutableIntObjectMap<ImmutableSortedSet<TradingPeriod>> immutablePool;

	public static void register(Symbol... symbols) {
		if (symbols == null)
			throw new IllegalArgumentException("Illegal Argument -> symbols is null");
		for (Symbol symbol : symbols)
			INSTANCE.putTradingPeriod(symbol);
	}

	private void putTradingPeriod(Symbol symbol) {
		if (!tradingPeriodMap.containsKey(symbol.getSymbolId()))
			tradingPeriodMap.put(symbol.getSymbolId(), symbol.getTradingPeriodSet());
	}

	public static void toImmutable() {
		INSTANCE.toImmutable0();
	}

	private void toImmutable0() {
		this.immutablePool = tradingPeriodMap.toImmutable();
	}

	/**
	 * 获取当前指定Symbol的交易周期Set
	 * 
	 * @param period
	 * @param symbol
	 * @return
	 */
	public static ImmutableSortedSet<TradingPeriod> getTradingPeriodSet(Instrument instrument) {
		return getTradingPeriodSet(instrument.getSymbol());
	}

	public static ImmutableSortedSet<TradingPeriod> getTradingPeriodSet(Symbol symbol) {
		if (INSTANCE.immutablePool == null)
			throw new NullPointerException("immutablePool is null, plz call static method toImmutable().");
		return INSTANCE.immutablePool.get(symbol.getSymbolId());
	}

}
