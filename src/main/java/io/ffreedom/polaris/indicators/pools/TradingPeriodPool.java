package io.ffreedom.polaris.indicators.pools;

import java.time.LocalTime;

import javax.annotation.concurrent.ThreadSafe;

import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.polaris.datetime.TradingPeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.financial.Symbol;
import io.ffreedom.polaris.financial.futures.ChinaFuturesSymbol;

@ThreadSafe
public final class TradingPeriodPool {

	public static final TradingPeriodPool Singleton = new TradingPeriodPool();

	private TradingPeriodPool() {
	}

	// Map<Symbol, Set<TimePeriod>>
	private MutableIntObjectMap<ImmutableSortedSet<TradingPeriod>> tradingPeriodMap = ECollections
			.newIntObjectHashMap();

	// Map<Symbol, Set<TimePeriod>>
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
		return immutablePool.get(symbol.getSymbolId());
	}

	public TradingPeriod getAfterTradingPeriod(Instrument instrument, LocalTime time) {
		return getAfterTradingPeriod(instrument.getSymbol(), time);
	}

	public TradingPeriod getAfterTradingPeriod(Symbol symbol, LocalTime time) {
		ImmutableSortedSet<TradingPeriod> tradingPeriodSet = getTradingPeriodSet(symbol);
		TradingPeriod rtnTradingPeriod = null;
		int baseTime = time.toSecondOfDay();
		int baseDiff = Integer.MAX_VALUE;
		for(TradingPeriod tradingPeriod : tradingPeriodSet) {
			int startSecondOfDay = tradingPeriod.getStartSecondOfDay();
			int diff = Math.abs(startSecondOfDay - baseTime);
			if(diff < baseDiff) {
				baseDiff = diff;
				rtnTradingPeriod = tradingPeriod;
			}
		}
		return rtnTradingPeriod;
	}
	
	public static void main(String[] args) {
		
		Singleton.register(ChinaFuturesSymbol.values());
		
		TradingPeriod afterTradingPeriod = Singleton.getAfterTradingPeriod(ChinaFuturesSymbol.RB, LocalTime.now());
		System.out.println(afterTradingPeriod.getStartTime());
	}

}
