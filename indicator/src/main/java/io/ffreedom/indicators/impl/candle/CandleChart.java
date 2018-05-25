package io.ffreedom.indicators.impl.candle;

import java.util.Collection;

import io.ffreedom.financial.Instrument;
import io.ffreedom.indicators.api.Indicator;
import io.ffreedom.indicators.api.IndicatorPeriod;
import io.ffreedom.market.data.MarketData;
import io.ffreedom.market.data.TradingPeriodSet;

public class CandleChart implements Indicator<Candle> {

	protected IndicatorPeriod period;
	protected CandleSet candleSet;
	protected Candle inTimeCandle;

	// private LinkedList<TradeSignal> tradeSignalList;
	// protected Open openState;
	// protected Close closeState;

	public CandleChart(Instrument instrument, IndicatorPeriod period) {
		TradingPeriodSet tradingPeriodSet = instrument.getSymbol().getTradingPeriodSet();

		this.period = period;
		this.candleSet = CandleSet.emptyCandleSet();

	}

	private boolean isNextBar(MarketData marketData) {
		// TODO 完成判断条件
		return false;
	}

	// public TradeSignal getTradeSignal() {
	// if(tradeSignalList.isEmpty()) {
	// return TradeSignalType.
	// }
	// return tradeSignalList.removeFirst();
	// }
	//
	// public void addTradeSignal(TradeSignal signal) {
	// tradeSignalList.addLast(signal);
	// }

	public void onMarketData(MarketData marketData) {
		if (isNextBar(marketData)) {
			candleSet.add(inTimeCandle);
			inTimeCandle = Candle.emptyCandle(marketData.getDatetime(), marketData.getInstrument(), period);
			// BarSet.add(inTimeBar);
		}
		inTimeCandle.onMarketData(marketData);// (t.getAskSet().first().getPrice());
	}

	@Override
	public int size() {
		return candleSet.size();
	}

	@Override
	public Candle getPoint(int i) {
		// candleSet.
		return null;
	}

	@Override
	public Collection<Candle> getPoints() {
		return candleSet.toCollection();
	}

	@Override
	public void startPoint() {
		// TODO Auto-generated method stub

	}

	@Override
	public void endPoint() {
		// TODO Auto-generated method stub

	}

}
