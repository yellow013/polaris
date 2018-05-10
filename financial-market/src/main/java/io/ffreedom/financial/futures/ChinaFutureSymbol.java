package io.ffreedom.financial.futures;

import java.time.LocalTime;

import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;

import io.ffreedom.financial.Exchange;
import io.ffreedom.financial.Symbol;
import io.ffreedom.market.TradingPeriod;
import io.ffreedom.market.TradingPeriodSet;

public enum ChinaFutureSymbol implements Symbol {

	rb("rb", TradingPeriodSet.newInstance(new TradingPeriod(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
			new TradingPeriod(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			new TradingPeriod(2, LocalTime.of(10, 15, 00), LocalTime.of(11, 30, 00)),
			new TradingPeriod(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00)))),

	a("a", TradingPeriodSet.newInstance(new TradingPeriod(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)))),

	i("i", TradingPeriodSet.newInstance(new TradingPeriod(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)))),

	;

	private String symbolName;

	private TradingPeriodSet tradingPeriodSet;

	private ChinaFutureSymbol(String symbolName, TradingPeriodSet tradingPeriodSet) {

		this.symbolName = symbolName;
		this.tradingPeriodSet = tradingPeriodSet;
	}

	@Override
	public String getSymbolName() {
		return symbolName;
	}

	@Override
	public TradingPeriodSet getTradingPeriodSet() {
		return tradingPeriodSet;
	}

	@Override
	public Exchange getExchange() {
		// TODO Auto-generated method stub
		return null;
	}

	private static MutableMap<String, ChinaFutureSymbol> innerMap = UnifiedMap.newMap();

	static {
		for (ChinaFutureSymbol symbol : ChinaFutureSymbol.values()) {
			innerMap.put(symbol.getSymbolName(), symbol);
		}
	}

	public static ChinaFutureSymbol checkOut(String symbolName) {
		if (innerMap.containsKey(symbolName)) {
			return innerMap.get(symbolName);
		}
		throw new IllegalArgumentException("Symbol Name -> " + symbolName + " is no mapping object");
	}

	public static void main(String[] args) {

		System.out.println(ChinaFutureSymbol.rb.getTradingPeriodSet().isTradingPeriod(LocalTime.of(23, 00, 1)));

	}

}
