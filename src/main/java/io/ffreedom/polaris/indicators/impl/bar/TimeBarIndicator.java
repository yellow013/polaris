package io.ffreedom.polaris.indicators.impl.bar;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.polaris.datetime.TimePeriodPool;
import io.ffreedom.polaris.datetime.XTimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.BaseTimePeriodIndicator;
import io.ffreedom.polaris.indicators.events.TimeBarsEvent;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public final class TimeBarIndicator extends BaseTimePeriodIndicator<TimeBar, TimeBarsEvent> {

	public TimeBarIndicator(Instrument instrument, IndicatorTimePeriod period) {
		super(instrument, period);
	}

	public static TimeBarIndicator with(Instrument instrument, IndicatorTimePeriod period) {
		return new TimeBarIndicator(instrument, period);
	}

	// @Override
	protected boolean isCurrentPointPeriod(BasicMarketData marketData) {
		return currentPoint.isPeriod(marketData.getZonedDateTime().toLocalDateTime());
	}

	// @Override
	protected TimeBar generateNextPoint(TimeBar currentPoint) {
		// 根据当前周期的开始时间和结束时间以及时间周期创建新的点
		TimeBar newPoint = currentPoint.generateNext();
		points.add(newPoint);
		return newPoint;
	}
	
	@Override
	protected TimeBar initialize() {
		// 从已经根据交易周期分配好的池中获取此指标的分割节点
		ImmutableSortedSet<XTimePeriod> timePeriodSet = TimePeriodPool.Singleton.getTimePeriodSet(period, instrument);
		int i = -1;
		for (XTimePeriod timePeriod : timePeriodSet)
			points.add(TimeBar.with(++i, instrument, period, timePeriod));
		return points.getFirst();
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	
}
