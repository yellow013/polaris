package io.ffreedom.polaris.indicators.impl.bar;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.polaris.datetime.TimePeriodPool;
import io.ffreedom.polaris.datetime.XTimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.base.AbstractTimePeriodIndicator;
import io.ffreedom.polaris.indicators.events.TimeBarsEvent;
import io.ffreedom.polaris.indicators.impl.bar.point.TimeBar;
import io.ffreedom.polaris.market.BasicMarketData;

public class TimeBars extends AbstractTimePeriodIndicator<TimeBar, TimeBarsEvent> {

	public TimeBars(Instrument instrument, IndicatorTimePeriod period) {
		super(instrument, period);
	}

	public static TimeBars with(Instrument instrument, IndicatorTimePeriod period) {
		return new TimeBars(instrument, period);
	}

	//@Override
	protected boolean isCurrentPointPeriod(BasicMarketData marketData) {
		return currentPoint.isPeriod(marketData.getZonedDateTime().toLocalDateTime());
	}

	//@Override
	protected TimeBar generateNextPoint(TimeBar currentPoint) {
		// 根据当前周期的开始时间和结束时间以及时间周期创建新的点
		TimeBar newPoint = currentPoint.generateNext();
		getPointSet().add(newPoint);
		return newPoint;
	}

	@Override
	protected void initPooledPoints(PointSet<TimeBar> points) {
		// 从已经根据交易周期分配好的池中获取此指标的分割节点
		ImmutableSortedSet<XTimePeriod> timePeriodSet = TimePeriodPool.Singleton.getTimePeriodSet(period, instrument);
		int i = -1;
		for (XTimePeriod timePeriod : timePeriodSet)
			points.add(TimeBar.with(++i, instrument, period, timePeriod));
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		

	}

}
