package io.ffreedom.indicators.impl.candle;

import java.util.Collection;

import io.ffreedom.indicators.api.Indicator;
import io.ffreedom.indicators.api.IndicatorPeriod;
import io.ffreedom.market.data.MarketData;

public class CandleChart implements Indicator<Candle, MarketData> {

	protected IndicatorPeriod period;
	protected CandleSet candleSet;
	protected Candle inTimeCandle;

	// private LinkedList<TradeSignal> tradeSignalList;
	// protected Open openState;
	// protected Close closeState;

	public CandleChart(IndicatorPeriod period) {
		super();
		this.period = period;
		this.candleSet = new CandleSet();
		this.inTimeCandle = Candle.emptyBar();
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

	@Override
	public void onTick(MarketData t) {
		if (isNextBar(t)) {
			candleSet.add(inTimeCandle);
			inTimeCandle = Candle.emptyBar();
			// BarSet.add(inTimeBar);
		}
		inTimeCandle.onTick(t);//(t.getAskSet().first().getPrice());
	}

	@Override
	public void onPoint(Candle p) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		return candleSet.size();
	}

	@Override
	public Candle getPoint(int i) {
		//candleSet.
		return null;
	}

	@Override
	public Collection<Candle> getPoints() {
		return candleSet.toCollection();
	}

}
