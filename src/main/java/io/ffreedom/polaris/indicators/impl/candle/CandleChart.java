package io.ffreedom.polaris.indicators.impl.candle;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;

import io.ffreedom.polaris.datetime.TimeTwin;
import io.ffreedom.polaris.datetime.TradingPeriod;
import io.ffreedom.polaris.datetime.tradingday.impl.TradingDayKeeper;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.AbstractIndicator;
import io.ffreedom.polaris.indicators.pools.IndicatorPeriodTimePools;
import io.ffreedom.polaris.market.BasicMarketData;

public class CandleChart extends AbstractIndicator<Candle> {

	private Instrument instrument;
	private IndicatorPeriod period;
	private CandleSet candleSet;
	private Candle currentCandle;

	private MutableSortedSet<TimeTwin> candleSetPeriods;

	public CandleChart(Instrument instrument, IndicatorPeriod period) {
		this.instrument = instrument;
		this.period = period;
		this.candleSet = CandleSet.newEmptyCandleSet();
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
				// 根据当前周期的开始时间和结束时间以及时间周期创建新的点
				currentCandle.getStartTime().plusSeconds(period.getSeconds());
				currentCandle.getEndTime().plusSeconds(period.getSeconds());
				TimeTwin.
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
		candleSet.getCandle(index).orElse(Candle.);
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

}
