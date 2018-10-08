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

	// Map<IndicatorPeriod, Map<Symbol, TimeTwin>>
	private MutableLongObjectMap<MutableIntObjectMap<ImmutableSet<TimeTwin>>> pools = LongObjectHashMap.newMap();

	public void register(IndicatorPeriod period, Symbol... symbols) {
		for (Symbol symbol : symbols) {
			register(period, symbol);
		}
	}

	public void register(IndicatorPeriod period, Symbol symbol) {
		MutableIntObjectMap<ImmutableSet<TimeTwin>> period$SymbolMap = pools.get(period.getSeconds());
		if (period$SymbolMap == null) {
			period$SymbolMap = IntObjectHashMap.newMap();
			pools.put(period.getSeconds(), period$SymbolMap);
		}
		if (!period$SymbolMap.containsKey(symbol.getSymbolId())) {
			MutableSet<TimeTwin> timeTwinSet = UnifiedSet.newSet();
			symbol.getTradingPeriodSet().forEach(tradingPeriod -> timeTwinSet
					.addAll(tradingPeriod.segmentByDuration(TradingDay.currentTradingDay(), period.getDuration())));
			period$SymbolMap.put(symbol.getSymbolId(), timeTwinSet.toImmutable());
		}
	}

}
