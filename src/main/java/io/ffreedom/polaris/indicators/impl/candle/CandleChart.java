package io.ffreedom.polaris.indicators.impl.candle;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

import org.eclipse.collections.api.set.ImmutableSet;

import io.ffreedom.polaris.datetime.TimeTwin;
import io.ffreedom.polaris.datetime.tradingday.TradingDayKeeper;
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

	public CandleChart(Instrument instrument, IndicatorPeriod period) {
		this.instrument = instrument;
		this.period = period;
		this.candleSet = CandleSet.newEmptyCandleSet();
		initCandleSet();
		initCurrentCandle();
	}

	private void initCandleSet() {
		// 从已经根据交易日分配好的池中获取此指标的分割节点
		ImmutableSet<TimeTwin> timeTwinSet = IndicatorPeriodTimePools.getTimeTwinSet(period, instrument.getSymbol());
		timeTwinSet.each(timeTwin -> candleSet.add(Candle.withTimeTwin(timeTwin, instrument, period)));
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
				LocalDateTime newStartTime = currentCandle.getStartTime().plusSeconds(period.getSeconds());
				LocalDateTime newEndTime = currentCandle.getEndTime().plusSeconds(period.getSeconds());
				currentCandle = Candle.withTimeTwin(
						TimeTwin.of(TradingDayKeeper.get(instrument), newStartTime, newEndTime), instrument,
						period);
			}
		}
	}

	@Override
	public int size() {
		return candleSet.size();
	}

	@Override
	public Candle getPoint(int index) {
		return candleSet.getCandle(index).orElseThrow(
				() -> new NullPointerException("getPoint(index) throw NullPointerException index==" + index));
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
