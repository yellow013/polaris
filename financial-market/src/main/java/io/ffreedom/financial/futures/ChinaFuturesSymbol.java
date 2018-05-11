package io.ffreedom.financial.futures;

import java.time.LocalTime;

import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;

import io.ffreedom.financial.Exchange;
import io.ffreedom.financial.Exchanges;
import io.ffreedom.financial.Symbol;
import io.ffreedom.market.TradingPeriod;
import io.ffreedom.market.TradingPeriodSet;

public enum ChinaFuturesSymbol implements Symbol {

	rb(Exchanges.SHFE, 
			TradingPeriod.of(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
			TradingPeriod.of(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.of(2, LocalTime.of(10, 15, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.of(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),

	cu(Exchanges.SHFE, 
			TradingPeriod.of(0, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00))),

	;

	private Exchange exchange;

	private TradingPeriodSet tradingPeriodSet;

	private ChinaFuturesSymbol(Exchange exchange, TradingPeriod... tradingPeriods) {
		this.exchange = exchange;
		this.tradingPeriodSet = TradingPeriodSet.newInstance(tradingPeriods);
	}

	@Override
	public String getSymbolName() {
		return this.name();
	}

	@Override
	public TradingPeriodSet getTradingPeriodSet() {
		return tradingPeriodSet;
	}

	@Override
	public Exchange getExchange() {
		return exchange;
	}

	private static MutableMap<String, ChinaFuturesSymbol> innerMap = UnifiedMap.newMap();

	static {
		for (ChinaFuturesSymbol symbol : ChinaFuturesSymbol.values()) {
			innerMap.put(symbol.name(), symbol);
		}
	}

	public static ChinaFuturesSymbol checkOut(String symbolName) {
		if (innerMap.containsKey(symbolName)) {
			return innerMap.get(symbolName);
		}
		throw new IllegalArgumentException("Symbol Name -> " + symbolName + " is no mapping object");
	}

	public static void main(String[] args) {

		System.out.println(ChinaFuturesSymbol.cu.getTradingPeriodSet().isTradingPeriod(LocalTime.of(23, 00, 1)));

	}

}
