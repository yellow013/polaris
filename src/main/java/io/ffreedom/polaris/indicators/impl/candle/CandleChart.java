package io.ffreedom.polaris.indicators.impl.candle;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.slf4j.Logger;

import io.ffreedom.common.functional.Callback;
import io.ffreedom.common.log.LoggerFactory;
import io.ffreedom.polaris.datetime.TradingDayKeeper;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.Indicator;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.pools.IndicatorPeriodTimePools;
import io.ffreedom.polaris.market.BasicMarketData;
import io.ffreedom.polaris.market.TimeTwin;
import io.ffreedom.polaris.market.TradingPeriod;

public class CandleChart implements Indicator<Candle> {

	private Instrument instrument;
	private IndicatorPeriod period;
	private CandleSet candleSet;
	private Candle currentCandle;

	private MutableSortedSet<TimeTwin> candleSetPeriods;

	private Callback<Candle> startPointCallback;
	private Callback<Candle> endPointCallback;

	private static Logger logger = LoggerFactory.getLogger(CandleChart.class);

	public CandleChart(Instrument instrument, IndicatorPeriod period) {
		this.instrument = instrument;
		this.period = period;
		this.candleSet = CandleSet.emptyCandleSet();
		initCandleSet();
		initCurrentCandle();
	}

	// TODO 进行池化处理
	private void initCandleSet() {
		ImmutableSet<TimeTwin> timeTwinSet = IndicatorPeriodTimePools.getTimeTwinSet(period, instrument.getSymbol());

		ImmutableSortedSet<TradingPeriod> immutableTradingPeriodSet = instrument.getSymbol().getTradingPeriodSet();
		this.candleSetPeriods = TreeSortedSet.newSet();
		immutableTradingPeriodSet.each(tradingPeriod -> candleSetPeriods.addAll(tradingPeriod
				.segmentByDuration(TradingDayKeeper.getInstance(instrument).current(), period.getDuration())));
		candleSetPeriods.each(timeTwin ->
		// TODO 添加TradingDay的可变性
		candleSet.add(Candle.withTimeTwin(timeTwin, instrument, period)));
	}

	private void initCurrentCandle() {
		this.currentCandle = candleSet.firstCandle();
	}

	private boolean isCurrentCandlePeriod(BasicMarketData marketData) {
		return currentCandle.isPeriod(marketData.getZonedDateTime().toLocalDateTime());
	}

	public void onMarketData(BasicMarketData marketData) {
		if (isCurrentCandlePeriod(marketData)) {
			currentCandle.onMarketData(marketData);
		} else {

			endPoint(currentCandle);
			Optional<Candle> nextCandle = candleSet.getNextCandle(currentCandle);
			if (nextCandle.isPresent()) {
				currentCandle = nextCandle.get();
			} else {
				// TODO 添加candleSet扩容
				currentCandle = Candle.withTimeTwin(null, instrument, period);
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
	public void endPoint(Candle p) {
		if (endPointCallback != null)
			endPointCallback.accept(p);
		else
			logger.error("this.endPointCallback is null.");
	}

	@Override
	public void registerEndPointEvent(Callback<Candle> callback) {
		this.endPointCallback = callback;
	}

	@Override
	public void startPoint(Candle p) {
		if (startPointCallback != null)
			startPointCallback.accept(p);
		else
			logger.info("this.startPointCallback is null.");
	}

	@Override
	public void registerStartPointEvent(Callback<Candle> callback) {
		this.startPointCallback = callback;
	}

}
