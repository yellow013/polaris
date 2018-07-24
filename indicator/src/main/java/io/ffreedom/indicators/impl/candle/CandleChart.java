package io.ffreedom.indicators.impl.candle;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;

import io.ffreedom.common.functional.Callback;
import io.ffreedom.financial.Instrument;
import io.ffreedom.indicators.api.Indicator;
import io.ffreedom.indicators.api.IndicatorPeriod;
import io.ffreedom.market.MarketData;
import io.ffreedom.market.TimeTwin;
import io.ffreedom.market.TradingDay;
import io.ffreedom.market.TradingPeriod;

public class CandleChart implements Indicator<Candle> {

	private Instrument instrument;
	private IndicatorPeriod period;
	private CandleSet candleSet;
	private Candle currentCandle;

	private MutableSortedSet<TimeTwin> candleSetPeriods;

	private Callback<Candle> endPointCallback;

	public CandleChart(Instrument instrument, IndicatorPeriod period) {
		this.instrument = instrument;
		this.period = period;
		this.candleSet = CandleSet.emptyCandleSet();
		initCandleSet();
		initCurrentCandle();
	}

	// TODO 进行池化处理
	private void initCandleSet() {
		ImmutableSortedSet<TradingPeriod> immutableTradingPeriodSet = instrument.getSymbol().getTradingPeriodSet()
				.getImmutableTradingPeriodSet();
		this.candleSetPeriods = TreeSortedSet.newSet();
		immutableTradingPeriodSet.each(tradingPeriod -> {
			candleSetPeriods.addAll(tradingPeriod.segmentByDuration(TradingDay.get(), period.getDuration()));
		});
		candleSetPeriods.each(timeTwin -> {
			// TODO 添加TradingDay的可变性
			candleSet.add(Candle.withTimeTwin(timeTwin, instrument, period));
		});
	}

	private void initCurrentCandle() {
		this.currentCandle = candleSet.firstCandle();
	}

	private boolean isCurrentCandlePeriod(MarketData marketData) {
		return currentCandle.isPeriod(marketData.getDatetime());
	}

	public void onMarketData(MarketData marketData) {
		if (isCurrentCandlePeriod(marketData)) {
			currentCandle.onMarketData(marketData);
		} else {
			endPoint(currentCandle);
			Optional<Candle> nextCandle = candleSet.getNextCandle(currentCandle);
			if (nextCandle.isPresent()) {
				currentCandle = nextCandle.get();
			} else {
				// TODO 添加candleSet扩容
				currentCandle = null;
			}
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
	public Candle getFastPoint() {
		return candleSet.firstCandle();
	}

	@Override
	public Candle getLastPoint() {
		return candleSet.lastCandle();
	}

	@Override
	public void endPoint(Candle candle) {
		endPointCallback.accept(candle);
	}

}
