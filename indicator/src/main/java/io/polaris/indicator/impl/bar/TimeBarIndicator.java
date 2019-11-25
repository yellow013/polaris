package io.polaris.indicator.impl.bar;

import java.time.LocalDateTime;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.market.impl.BasicMarketData;
import io.polaris.financial.time.TimePeriodPool;
import io.polaris.indicator.base.BaseTimePeriodIndicator;
import io.polaris.indicator.events.TimeBarsEvent;
import io.polaris.vector.TimePeriod;
import io.polaris.vector.TimePeriodSerial;

public final class TimeBarIndicator extends BaseTimePeriodIndicator<TimeBar, TimeBarsEvent> {

	public TimeBarIndicator(Instrument instrument, TimePeriod period) {
		super(instrument, period);
		// 从已经根据交易周期分配好的池中获取此指标的分割节点
		ImmutableSortedSet<TimePeriodSerial> timePeriodSet = TimePeriodPool.Singleton.getTimePeriodSet(period,
				instrument);
		int i = -1;
		for (TimePeriodSerial timePeriod : timePeriodSet)
			pointSet.add(TimeBar.with(++i, instrument, period, timePeriod));
		currentPoint = pointSet.getFirst();
	}

	public static TimeBarIndicator with(Instrument instrument, TimePeriod period) {
		return new TimeBarIndicator(instrument, period);
	}

	// @Override
	protected TimeBar generateNextPoint(TimeBar currentPoint) {
		// 根据当前周期的开始时间和结束时间以及时间周期创建新的点
		TimeBar newPoint = currentPoint.generateNext();
		pointSet.add(newPoint);
		return newPoint;
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		TimePeriodSerial currentPointSerial = currentPoint.getSerial();
		LocalDateTime marketDataTime = marketData.getZonedDateTime().toLocalDateTime();
		if (currentPointSerial.isPeriod(marketData.getZonedDateTime().toLocalDateTime())) {
			currentPoint.onMarketData(marketData);
			for (TimeBarsEvent timeBarsEvent : events)
				timeBarsEvent.onCurrentTimeBarChanged(currentPoint);
		} else {
			for (TimeBarsEvent timeBarsEvent : events)
				timeBarsEvent.onEndTimeBar(currentPoint);
			TimeBar newBar = pointSet.nextOf(currentPoint).orElse(null);
			if (newBar == null) {
				logger.error("TimeBar [{}-{}] next is null.", currentPointSerial.getStartTime(),
						currentPointSerial.getEndTime());
				return;
			}
			while (!newBar.getSerial().isPeriod(marketDataTime)) {
				newBar.onMarketData(preMarketData);
				for (TimeBarsEvent timeBarsEvent : events)
					timeBarsEvent.onStartTimeBar(newBar);
				for (TimeBarsEvent timeBarsEvent : events)
					timeBarsEvent.onEndTimeBar(newBar);
				newBar = pointSet.nextOf(currentPoint).orElseGet(null);
				if (newBar == null) {
					logger.error("TimeBar [{}-{}] next is null.", currentPointSerial.getStartTime(),
							currentPointSerial.getEndTime());
					break;
				}
			}
			for (TimeBarsEvent timeBarsEvent : events)
				timeBarsEvent.onStartTimeBar(newBar);
		}

	}

}
