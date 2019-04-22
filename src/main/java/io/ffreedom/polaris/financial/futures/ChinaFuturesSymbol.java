package io.ffreedom.polaris.financial.futures;

import java.time.LocalTime;

import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;

import io.ffreedom.common.collect.ImmutableSets;
import io.ffreedom.polaris.datetime.TradingPeriod;
import io.ffreedom.polaris.financial.Exchange;
import io.ffreedom.polaris.financial.Symbol;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;

public enum ChinaFuturesSymbol implements Symbol {

	// ************************上期所************************//
	/**
	 * 铜
	 */
	CU(1, Exchange.SHFE,
			// 铜期货交易时段
			TradingPeriod.with(0, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00)),
			TradingPeriod.with(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
	/**
	 * 铝
	 */
	AL(2, Exchange.SHFE,
			// 铝期货交易时段
			TradingPeriod.with(0, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00)),
			TradingPeriod.with(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
	/**
	 * 锌
	 */
	ZN(3, Exchange.SHFE,
			// 锌期货交易时段
			TradingPeriod.with(0, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00)),
			TradingPeriod.with(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
	/**
	 * 铅
	 */
	PB(4, Exchange.SHFE,
			// 铅期货交易时段
			TradingPeriod.with(0, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00)),
			TradingPeriod.with(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
	/**
	 * 镍
	 */
	NI(5, Exchange.SHFE,
			// 镍期货交易时段
			TradingPeriod.with(0, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00)),
			TradingPeriod.with(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
	/**
	 * 锡
	 */
	SN(6, Exchange.SHFE,
			// 锡期货交易时段
			TradingPeriod.with(0, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00)),
			TradingPeriod.with(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
	/**
	 * 黄金
	 */
	AU(7, Exchange.SHFE,
			// 黄金期货交易时段
			TradingPeriod.with(0, LocalTime.of(21, 00, 00), LocalTime.of(2, 30, 00)),
			TradingPeriod.with(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
	/**
	 * 白银
	 */
	AG(8, Exchange.SHFE,
			// 白银期货交易时段
			TradingPeriod.with(0, LocalTime.of(21, 00, 00), LocalTime.of(2, 30, 00)),
			TradingPeriod.with(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
	/**
	 * 螺纹钢
	 */
	RB(9, Exchange.SHFE,
			// 螺纹钢期货交易时段
			TradingPeriod.with(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
			TradingPeriod.with(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
	/**
	 * 热卷扎板
	 */
	HC(10, Exchange.SHFE,
			// 热卷扎板期货交易时段
			TradingPeriod.with(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
			TradingPeriod.with(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
	/**
	 * 沥青
	 */
	BU(11, Exchange.SHFE,
			// 沥青期货交易时段
			TradingPeriod.with(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
			TradingPeriod.with(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
	/**
	 * 橡胶
	 */
	RU(12, Exchange.SHFE,
			// 橡胶期货交易时段
			TradingPeriod.with(0, LocalTime.of(21, 00, 00), LocalTime.of(23, 00, 00)),
			TradingPeriod.with(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),
	// ************************上期所END************************//

	// ************************能源交易所************************//
	/**
	 * 原油
	 */
	SC(1, Exchange.SIEE,
			// 原油期货交易时段
			TradingPeriod.with(0, LocalTime.of(21, 00, 00), LocalTime.of(1, 00, 00)),
			TradingPeriod.with(1, LocalTime.of(9, 00, 00), LocalTime.of(10, 15, 00)),
			TradingPeriod.with(2, LocalTime.of(10, 30, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(3, LocalTime.of(13, 30, 00), LocalTime.of(15, 00, 00))),

	// ************************能源交易所END************************//

	// ************************中金所************************//
	/**
	 * 上证300期货
	 */
	IF(1, Exchange.CFFE,
			// 股指期货交易时段
			TradingPeriod.with(0, LocalTime.of(9, 15, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(1, LocalTime.of(13, 00, 00), LocalTime.of(15, 15, 00))),

	/**
	 * 中证500期货
	 */
	IC(2, Exchange.CFFE,
			// 股指期货交易时段
			TradingPeriod.with(0, LocalTime.of(9, 15, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(1, LocalTime.of(13, 00, 00), LocalTime.of(15, 15, 00))),

	/**
	 * 债券期货
	 */
	TF(3, Exchange.CFFE,
			// 股指期货交易时段
			TradingPeriod.with(0, LocalTime.of(9, 15, 00), LocalTime.of(11, 30, 00)),
			TradingPeriod.with(1, LocalTime.of(13, 00, 00), LocalTime.of(15, 15, 00))),
	// ************************中金所END************************//
	;

	private int symbolId;

	private Exchange exchange;

	private ImmutableSortedSet<TradingPeriod> tradingPeriodSet;

	private ChinaFuturesSymbol(int exchangeNo, Exchange exchange, TradingPeriod... tradingPeriods) {
		this.symbolId = exchange.getExchangeId() + exchangeNo * 10000;
		this.exchange = exchange;
		this.tradingPeriodSet = ImmutableSets.newImmutableSortedSet(tradingPeriods);
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
	public ImmutableSortedSet<TradingPeriod> getTradingPeriodSet() {
		return tradingPeriodSet;
	}

	@Override
	public Exchange getExchange() {
		return exchange;
	}

	private static MutableIntObjectMap<ChinaFuturesSymbol> symbolIdMap = IntObjectHashMap.newMap();
	private static MutableMap<String, ChinaFuturesSymbol> symbolNameMap = UnifiedMap.newMap();

	static {
		for (ChinaFuturesSymbol symbol : ChinaFuturesSymbol.values()) {
			symbolIdMap.put(symbol.getSymbolId(), symbol);
			symbolNameMap.put(symbol.name(), symbol);
		}
	}

	public static ChinaFuturesSymbol checkout(String symbolName) {
		String key = symbolName.toUpperCase();
		ChinaFuturesSymbol chinaFuturesSymbol = symbolNameMap.get(key);
		if (chinaFuturesSymbol == null)
			throw new IllegalArgumentException("Symbol Name -> " + symbolName + " is no mapping object");
		return chinaFuturesSymbol;
	}

	public static ChinaFuturesSymbol checkout(int symbolId) {
		ChinaFuturesSymbol chinaFuturesSymbol = symbolIdMap.get(symbolId);
		if (chinaFuturesSymbol == null)
			throw new IllegalArgumentException("Symbol Id -> " + symbolId + " is no mapping object");
		return chinaFuturesSymbol;
	}

	public int generateInstrumentId(int term) {
		if (term > 9999)
			throw new IllegalArgumentException("Term > 9999, Is too much.");
		return symbolId + term;
	}

	public static void main(String[] args) {
		for (Symbol symbol : ChinaFuturesSymbol.values()) {
			symbol.getTradingPeriodSet()
					.each(tradingPeriod -> tradingPeriod.segmentByDuration(IndicatorPeriod.S30.getDuration())
							.each(timePeriod -> System.out.println(symbol.getSymbolCode() + " | " + timePeriod.getEpochTime()
									+ " -> " + timePeriod.getStartTime() + " - " + timePeriod.getEndTime())));
		}
	}

}
