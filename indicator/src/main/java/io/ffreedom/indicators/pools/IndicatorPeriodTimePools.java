package io.ffreedom.indicators.pools;

import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;

import io.ffreedom.financial.Symbol;
import io.ffreedom.indicators.api.IndicatorPeriod;
import io.ffreedom.market.TimeTwin;
import io.ffreedom.market.TradingDay;

public final class IndicatorPeriodTimePools {

	public static final IndicatorPeriodTimePools INSTANCE = new IndicatorPeriodTimePools();

	// Map<IndicatorPeriod, Map<Symbol, Set<TimeTwin>>>
	private MutableLongObjectMap<MutableIntObjectMap<ImmutableSet<TimeTwin>>> pools = LongObjectHashMap.newMap();

	public void register(IndicatorPeriod period, Symbol[] symbols) {
		MutableIntObjectMap<ImmutableSet<TimeTwin>> symbolMap = getSymbolMap(period);
		for (Symbol symbol : symbols)
			findOrGenerate(symbolMap, period, symbol);
	}

	public ImmutableSet<TimeTwin> getTimeTwinSet(IndicatorPeriod period, Symbol symbol) {
		return findOrGenerate(getSymbolMap(period), period, symbol);
	}

	private MutableIntObjectMap<ImmutableSet<TimeTwin>> getSymbolMap(IndicatorPeriod period) {
		MutableIntObjectMap<ImmutableSet<TimeTwin>> symbolMap = pools.get(period.getSeconds());
		if (symbolMap == null) {
			symbolMap = IntObjectHashMap.newMap();
			pools.put(period.getSeconds(), symbolMap);
		}
		return symbolMap;
	}

	private ImmutableSet<TimeTwin> findOrGenerate(MutableIntObjectMap<ImmutableSet<TimeTwin>> symbolMap,
			IndicatorPeriod period, Symbol symbol) {
		ImmutableSet<TimeTwin> timeTwinSet = symbolMap.get(symbol.getSymbolId());
		if (timeTwinSet != null) {
			return timeTwinSet;
		} else {
			MutableSet<TimeTwin> mutableTimeTwinSet = UnifiedSet.newSet();
			symbol.getTradingPeriodSet().forEach(tradingPeriod -> mutableTimeTwinSet
					.addAll(tradingPeriod.segmentByDuration(TradingDay.currentTradingDay(), period.getDuration())));
			return symbolMap.put(symbol.getSymbolId(), mutableTimeTwinSet.toImmutable());
		}
	}

}
