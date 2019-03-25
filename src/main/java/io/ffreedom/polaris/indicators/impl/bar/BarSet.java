package io.ffreedom.polaris.indicators.impl.bar;

import java.time.LocalDateTime;
import java.util.Optional;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.datetime.tradingday.TradingDayKeeper;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractIndicator;
import io.ffreedom.polaris.indicators.pools.TimePeriodPool;
import io.ffreedom.polaris.market.BasicMarketData;

public class BarSet extends AbstractIndicator<Bar> {

	public BarSet(Instrument instrument, IndicatorPeriod period) {
		super(instrument, period);
	}

	public static BarSet with(Instrument instrument, IndicatorPeriod period) {
		return new BarSet(instrument, period);
	}

	@Override
	protected PointSet<Bar> initPoints() {
		PointSet<Bar> bars = PointSet.emptyPointSet(256);
		// 从已经根据交易周期分配好的池中获取此指标的分割节点
		ImmutableSortedSet<TimePeriod> timePeriodSet = TimePeriodPool.Singleton.getTimePeriodSet(period, instrument.getSymbol());
		timePeriodSet.each(timePeriod -> bars.add(Bar.with(period, timePeriod, instrument)));
		return bars;
	}

	@Override
	protected Bar initCurrentPoint() {
		return getPointSet().getFirst();
	}

	private boolean isCurrentCandlePeriod(BasicMarketData marketData) {
		return currentPoint.isPeriod(marketData.getZonedDateTime().toLocalDateTime());
	}

	public void onMarketData(BasicMarketData marketData) {
		if (isCurrentCandlePeriod(marketData)) {
			currentPoint.onMarketData(marketData);
		} else {
			endPoint(currentPoint);
			Optional<Bar> nextBar = getPointSet().nextOf(currentPoint);
			if (nextBar.isPresent()) {
				currentPoint = nextBar.get();
			} else {
				// 根据当前周期的开始时间和结束时间以及时间周期创建新的点
				LocalDateTime newStartTime = currentPoint.getStartTime().plusSeconds(period.getSeconds());
				LocalDateTime newEndTime = currentPoint.getEndTime().plusSeconds(period.getSeconds());
				currentPoint = Bar.with(period,
						TimePeriod.with(TradingDayKeeper.get(instrument), newStartTime, newEndTime), instrument);
				getPointSet().add(currentPoint);
			}
		}
	}

}
