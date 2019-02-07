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
import io.ffreedom.market.TradingDayKeeper;

public final class IndicatorPeriodTimePools {

	private static final IndicatorPeriodTimePools INSTANCE = new IndicatorPeriodTimePools();

	// Map<IndicatorPeriod, Map<Symbol, Set<TimeTwin>>>
	private MutableLongObjectMap<MutableIntObjectMap<ImmutableSet<TimeTwin>>> pools = LongObjectHashMap.newMap();

	public static void register(IndicatorPeriod period, Symbol[] symbols) {
		INSTANCE.register0(period, symbols);
	}

	private void register0(IndicatorPeriod period, Symbol[] symbols) {
		MutableIntObjectMap<ImmutableSet<TimeTwin>> symbolMap = getSymbolMap(period);
		for (Symbol symbol : symbols)
			findOrCreate(symbolMap, period, symbol);
	}

	public static ImmutableSet<TimeTwin> getTimeTwinSet(IndicatorPeriod period, Symbol symbol) {
		return INSTANCE.findOrCreate(INSTANCE.getSymbolMap(period), period, symbol);
	}

	private MutableIntObjectMap<ImmutableSet<TimeTwin>> getSymbolMap(IndicatorPeriod period) {
		MutableIntObjectMap<ImmutableSet<TimeTwin>> symbolMap = pools.get(period.getSeconds());
		if (symbolMap == null) {
			symbolMap = IntObjectHashMap.newMap();
			pools.put(period.getSeconds(), symbolMap);
		}
		return symbolMap;
	}

	private ImmutableSet<TimeTwin> findOrCreate(MutableIntObjectMap<ImmutableSet<TimeTwin>> symbolMap,
			IndicatorPeriod period, Symbol symbol) {
		ImmutableSet<TimeTwin> timeTwinSet = symbolMap.get(symbol.getSymbolId());
		if (timeTwinSet != null)
			return timeTwinSet;
		else {
			MutableSet<TimeTwin> mutableTimeTwinSet = UnifiedSet.newSet();
			symbol.getTradingPeriodSet().forEach(tradingPeriod -> mutableTimeTwinSet.addAll(tradingPeriod
					.segmentByDuration(TradingDayKeeper.getInstance(symbol).current(), period.getDuration())));
			return symbolMap.put(symbol.getSymbolId(), mutableTimeTwinSet.toImmutable());
		}
	}

}
