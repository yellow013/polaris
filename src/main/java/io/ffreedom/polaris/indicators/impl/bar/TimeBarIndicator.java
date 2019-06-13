package io.ffreedom.polaris.indicators.impl.bar;

import java.time.LocalDateTime;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.polaris.datetime.TimePeriodPool;
import io.ffreedom.polaris.datetime.TimePeriodSerial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.BaseTimePeriodIndicator;
import io.ffreedom.polaris.indicators.events.TimeBarsEvent;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public final class TimeBarIndicator extends BaseTimePeriodIndicator<TimeBar, TimeBarsEvent> {

	public TimeBarIndicator(Instrument instrument, IndicatorTimePeriod period) {
		super(instrument, period);
		// 从已经根据交易周期分配好的池中获取此指标的分割节点
		ImmutableSortedSet<TimePeriodSerial> timePeriodSet = TimePeriodPool.Singleton.getTimePeriodSet(period,
				instrument);
		int i = -1;
		for (TimePeriodSerial timePeriod : timePeriodSet)
			pointSet.add(TimeBar.with(++i, instrument, period, timePeriod));
		currentPoint = pointSet.getFirst();
	}

	public static TimeBarIndicator with(Instrument instrument, IndicatorTimePeriod period) {
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
			for (TimeBarsEvent timeBarsEvent : indicatorEvents) {
				timeBarsEvent.onCurrentTimeBarChanged(currentPoint);
			}
		} else {
			for (TimeBarsEvent timeBarsEvent : indicatorEvents) {
				timeBarsEvent.onEndTimeBar(currentPoint);
			}
			TimeBar newBar = pointSet.nextOf(currentPoint).orElse(null);
			if (newBar == null) {
				logger.error("TimeBar [{}-{}] next is null.", currentPointSerial.getStartTime(),
						currentPointSerial.getEndTime());
				return;
			}
			while (!newBar.getSerial().isPeriod(marketDataTime)) {
				newBar.onMarketData(preMarketData);
				for (TimeBarsEvent timeBarsEvent : indicatorEvents)
					timeBarsEvent.onStartTimeBar(newBar);
				for (TimeBarsEvent timeBarsEvent : indicatorEvents)
					timeBarsEvent.onEndTimeBar(newBar);
				newBar = pointSet.nextOf(currentPoint).orElseGet(null);
				if (newBar == null) {
					logger.error("TimeBar [{}-{}] next is null.", currentPointSerial.getStartTime(),
							currentPointSerial.getEndTime());
					break;
				}
			}
			for (TimeBarsEvent timeBarsEvent : indicatorEvents) {
				timeBarsEvent.onStartTimeBar(newBar);
			}
		}

	}

}
