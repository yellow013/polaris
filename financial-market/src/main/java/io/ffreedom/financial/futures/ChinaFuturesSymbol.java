package io.ffreedom.financial.futures;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;

import io.ffreedom.financial.Symbol;
import io.ffreedom.market.data.TradingPeriod;
import io.ffreedom.market.data.TradingPeriodSet;
import io.ffreedom.market.role.Exchange;

public enum ChinaFuturesSymbol implements Symbol {

	rb(1,ChinaFuturesExchange.SHFE,
			// 上期所螺纹钢期货交易时段
			TradingPeriod.with(1, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
			TradingPeriod.with(2, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(3, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(4, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),

	cu(2,ChinaFuturesExchange.SHFE,
			// 上期所铜期货交易时段
			TradingPeriod.with(1, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00)),
			TradingPeriod.with(2, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(3, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(4, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),

	ni(3,ChinaFuturesExchange.SHFE,
			// 上期所镍期货交易时段
			TradingPeriod.with(1, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00)),
			TradingPeriod.with(2, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(3, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(4, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),

	;
	
	private int symbolId;

	private Exchange exchange;

	private TradingPeriodSet tradingPeriodSet;

	private ChinaFuturesSymbol(int symbolId, Exchange exchange, TradingPeriod... tradingPeriods) {
		this.symbolId = symbolId;
		this.exchange = exchange;
		this.tradingPeriodSet = TradingPeriodSet.with(tradingPeriods);
	}

	@Override
	public int getSymbolId() {
		return symbolId;
	}

	@Override
	public String getSymbolCode() {
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
		ChinaFuturesSymbol.cu.getTradingPeriodSet().getImmutableTradingPeriodSet().each(tradingPeriod -> {
			tradingPeriod.segmentByDuration(LocalDate.of(2018, Month.JUNE, 20), Duration.ofMinutes(30))
					.each(timeTwins -> {
						System.out.println(timeTwins.getSerialNumber() + " -> " + timeTwins.getStartDateTime() + " - "
								+ timeTwins.getEndDateTime());
					});
		});
	}

	
}
