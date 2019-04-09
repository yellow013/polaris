package io.ffreedom.polaris.indicators.impl.bar;

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
	protected boolean isCurrentPointPeriod(BasicMarketData marketData) {
		return currentPoint.isPeriod(marketData.getZonedDateTime().toLocalDateTime());
	}

	@Override
	protected Bar generateNextPoint(Bar currentPoint) {
		// 根据当前周期的开始时间和结束时间以及时间周期创建新的点
		Bar newPoint = currentPoint.generateNext();
		getPointSet().add(newPoint);
		return newPoint;
	}

	@Override
	protected void initPooledPoints(PointSet<Bar> points) {
		// 从已经根据交易周期分配好的池中获取此指标的分割节点
		ImmutableSortedSet<TimePeriod> timePeriodSet = TimePeriodPool.Singleton.getTimePeriodSet(period, instrument);
		int i = -1;
		for (TimePeriod timePeriod : timePeriodSet)
			points.add(Bar.with(++i, instrument, period, timePeriod));
	}

}
