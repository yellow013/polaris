package io.polaris.financial.instrument.futures;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.common.collections.ImmutableMaps;
import io.ffreedom.common.collections.ImmutableSets;
import io.polaris.financial.instrument.Exchange;
import io.polaris.financial.instrument.Symbol;
import io.polaris.financial.time.TradingPeriod;
import io.polaris.vector.TimePeriod;

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
		this.tradingPeriodSet = ImmutableSets.newSortedSet(tradingPeriods);
	}

	@Override
	public int getSymbolId() {
		return symbolId;
	}

	@Override
	public String getSymbolName() {
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

	// 建立SymbolId -> Symbol的映射
	private final static ImmutableIntObjectMap<ChinaFuturesSymbol> symbolIdMap = ImmutableMaps.IntObjectMapFactory()
			.from(
					// 将ChinaFuturesSymbol转换为Iterable, 取SymbolId为Key
					Arrays.asList(ChinaFuturesSymbol.values()), ChinaFuturesSymbol::getSymbolId, symbol -> symbol);

	// 建立SymbolNeam -> Symbol的映射
	private final static ImmutableMap<String, ChinaFuturesSymbol> symbolNameMap = ImmutableMaps.newMap(
			// 将ChinaFuturesSymbol转换为Map
			Stream.of(ChinaFuturesSymbol.values()).collect(Collectors.toMap(
					// 取SymbolName为Key
					ChinaFuturesSymbol::getSymbolName, symbol -> symbol)));

	public static ChinaFuturesSymbol findOf(String symbolName) {
		String key = symbolName.toUpperCase();
		ChinaFuturesSymbol chinaFuturesSymbol = symbolNameMap.get(key);
		if (chinaFuturesSymbol == null)
			throw new IllegalArgumentException("Symbol Name -> " + symbolName + " is no mapping object");
		return chinaFuturesSymbol;
	}

	public static ChinaFuturesSymbol findOf(int symbolId) {
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
					.each(tradingPeriod -> tradingPeriod.segmentByDuration(TimePeriod.S30.getDuration()).each(
							timePeriod -> System.out.println(symbol.getSymbolName() + " | " + timePeriod.getEpochTime()
									+ " -> " + timePeriod.getStartTime() + " - " + timePeriod.getEndTime())));
		}

	}

}
