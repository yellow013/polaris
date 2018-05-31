package io.ffreedom.indicators.impl.candle;

import java.util.Collection;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.financial.Instrument;
import io.ffreedom.indicators.api.Indicator;
import io.ffreedom.indicators.api.IndicatorPeriod;
import io.ffreedom.market.data.MarketData;
import io.ffreedom.market.data.TradingPeriod;
import io.ffreedom.market.data.TradingPeriodSet;

public class CandleChart implements Indicator<Candle> {

	private Instrument instrument;
	private IndicatorPeriod period;
	private CandleSet candleSet;
	private Candle currentCandle;

	// private LinkedList<TradeSignal> tradeSignalList;
	// protected Open openState;
	// protected Close closeState;

	public CandleChart(Instrument instrument, IndicatorPeriod period) {
		this.instrument = instrument;
		this.period = period;
		this.candleSet = CandleSet.emptyCandleSet();
		initCandleSet();
		initCurrentCandle();
	}

	private void initCandleSet() {
		// 进行池化处理
		TradingPeriodSet tradingPeriodSet = instrument.getSymbol().getTradingPeriodSet();
		ImmutableSortedSet<TradingPeriod> immutableTradingPeriodSet = tradingPeriodSet.getImmutableTradingPeriodSet();
		immutableTradingPeriodSet.each(tradingPeriod -> {

		});

	}

	private void initCurrentCandle() {
		this.currentCandle = candleSet.firstCandle();
	}

	private boolean isNextBar(MarketData marketData) {

		return false;
	}

	public void onMarketData(MarketData marketData) {
		if (currentCandle == null) {
			currentCandle = Candle.withFirstMarketData(marketData, period);
		}
		if (isNextBar(marketData)) {

		}

	}

	@Override
	public int size() {
		return candleSet.size();
	}

	@Override
	public Candle getPoint(int i) {

		return null;
	}

	@Override
	public Collection<Candle> getPoints() {
		return candleSet.toCollection();
	}

	@Override
	public void startPoint() {

	}

	@Override
	public void endPoint() {

	}

	@Override
	public Candle getFastPoint() {
		return candleSet.firstCandle();
	}

	@Override
	public Candle getLastPoint() {
		return candleSet.lastCandle();
	}

}
