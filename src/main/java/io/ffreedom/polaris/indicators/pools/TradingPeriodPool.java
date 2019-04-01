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

	public static final TradingPeriodPool Singleton = new TradingPeriodPool();

	private TradingPeriodPool() {
	}

	// Map<IndicatorPeriod, Map<Symbol, Set<TimePeriod>>>
	private MutableIntObjectMap<ImmutableSortedSet<TradingPeriod>> tradingPeriodMap = ECollections
			.newIntObjectHashMap();

	// Map<IndicatorPeriod, Map<Symbol, Map<SerialNumber, TimePeriod>>>
	private ImmutableIntObjectMap<ImmutableSortedSet<TradingPeriod>> immutablePool;

	public void register(Symbol... symbols) {
		if (symbols == null)
			throw new IllegalArgumentException("Illegal Argument -> symbols is null");
		for (Symbol symbol : symbols)
			putTradingPeriod(symbol);
		toImmutable();
	}

	private void putTradingPeriod(Symbol symbol) {
		if (!tradingPeriodMap.containsKey(symbol.getSymbolId()))
			tradingPeriodMap.put(symbol.getSymbolId(), symbol.getTradingPeriodSet());
	}

	private void toImmutable() {
		this.immutablePool = tradingPeriodMap.toImmutable();
	}

	/**
	 * 获取当前指定Symbol的交易周期Set
	 * 
	 * @param period
	 * @param symbol
	 * @return
	 */
	public ImmutableSortedSet<TradingPeriod> getTradingPeriodSet(Instrument instrument) {
		return getTradingPeriodSet(instrument.getSymbol());
	}

	public ImmutableSortedSet<TradingPeriod> getTradingPeriodSet(Symbol symbol) {
		if (immutablePool == null)
			throw new NullPointerException("immutablePool is null, plz call method toImmutable().");
		return immutablePool.get(symbol.getSymbolId());
	}

}
