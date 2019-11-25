package io.polaris.indicators.events;

import java.time.temporal.TemporalAdjuster;

import io.polaris.indicators.api.IndicatorEvent;

public interface TimeEvent<T extends TemporalAdjuster> extends IndicatorEvent{

	void onTime(T time);

}
