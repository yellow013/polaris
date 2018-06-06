package io.ffreedom.indicators.impl.candle;

import java.util.Collection;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;

import io.ffreedom.financial.Instrument;
import io.ffreedom.indicators.api.Indicator;
import io.ffreedom.indicators.api.IndicatorPeriod;
import io.ffreedom.market.data.MarketData;
import io.ffreedom.market.data.TimeTwin;
import io.ffreedom.market.data.TradingPeriod;
import io.ffreedom.market.data.TradingPeriodSet;

public class CandleChart implements Indicator<Candle> {

	private Instrument instrument;
	private IndicatorPeriod period;
	private CandleSet candleSet;
	private Candle currentCandle;

	private MutableSortedSet<TimeTwin> candleSetPeriods;

	public CandleChart(Instrument instrument, IndicatorPeriod period) {
		this.instrument = instrument;
		this.period = period;
		this.candleSet = CandleSet.emptyCandleSet();
		initCandleSet();
		initCurrentCandle();
	}

	// TODO 进行池化处理
	private void initCandleSet() {
		TradingPeriodSet tradingPeriodSet = instrument.getSymbol().getTradingPeriodSet();
		ImmutableSortedSet<TradingPeriod> immutableTradingPeriodSet = tradingPeriodSet.getImmutableTradingPeriodSet();
		this.candleSetPeriods = TreeSortedSet.newSet();
		immutableTradingPeriodSet.each(tradingPeriod -> {
			candleSetPeriods.addAll(tradingPeriod.segmentByDuration(period.getDuration()));
		});
	}

	private void initCurrentCandle() {
		this.currentCandle = candleSet.firstCandle();
	}

	private boolean isNextCandle(MarketData marketData) {
		
		return false;
	}

	public void onMarketData(MarketData marketData) {
		if (currentCandle == null) {
			currentCandle = Candle.withFirstMarketData(marketData, period);
		}
		if (isNextCandle(marketData)) {
			
		}

	}

	@Override
	public int size() {
		return candleSet.size();
	}

	@Override
	public Candle getPoint(int index) {
		candleSet.getCandle(index);
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
