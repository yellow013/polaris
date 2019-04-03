package io.ffreedom.polaris.indicators.impl.bar;

import java.time.LocalDateTime;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractPooledIndicator;
import io.ffreedom.polaris.indicators.impl.bar.point.Bar;
import io.ffreedom.polaris.indicators.pools.TimePeriodPool;
import io.ffreedom.polaris.market.BasicMarketData;

public class PooledBars extends AbstractPooledIndicator<Bar> {

	public PooledBars(Instrument instrument, IndicatorPeriod period) {
		super(instrument, period, IndicatorCycle.with(1));
	}

	public static PooledBars with(Instrument instrument, IndicatorPeriod period) {
		return new PooledBars(instrument, period);
	}

	@Override
	protected PointSet<Bar> initPoints() {
		PointSet<Bar> bars = PointSet.emptyPointSet(256);
		// 从已经根据交易周期分配好的池中获取此指标的分割节点
		ImmutableSortedSet<TimePeriod> timePeriodSet = TimePeriodPool.Singleton.getTimePeriodSet(period, instrument);
		timePeriodSet.each(timePeriod -> bars.add(Bar.with(period, timePeriod, instrument)));
		return bars;
	}

	@Override
	protected Bar initCurrentPoint() {
		return getPointSet().getFirst();
	}

	@Override
	protected boolean isCurrentPointPeriod(BasicMarketData marketData) {
		return currentPoint.isPeriod(marketData.getZonedDateTime().toLocalDateTime());
	}

	@Override
	protected Bar generateNextPoint(Bar currentPoint) {
		// 根据当前周期的开始时间和结束时间以及时间周期创建新的点
		LocalDateTime newStartTime = currentPoint.getStartTime().plusSeconds(period.getSeconds());
		LocalDateTime newEndTime = currentPoint.getEndTime().plusSeconds(period.getSeconds());
		Bar newPoint = Bar.with(period, TimePeriod.with(newStartTime, newEndTime), instrument);
		getPointSet().add(newPoint);
		return newPoint;
	}

}
