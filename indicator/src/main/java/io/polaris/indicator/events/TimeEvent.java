package io.polaris.indicator.events;

import java.time.temporal.TemporalAdjuster;

import io.polaris.indicator.api.IndicatorEvent;

public interface TimeEvent<T extends TemporalAdjuster> extends IndicatorEvent{

	void onTime(T time);

}
