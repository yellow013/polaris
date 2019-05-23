package io.ffreedom.polaris.indicators.events;

import java.time.temporal.TemporalAdjuster;

import io.ffreedom.polaris.indicators.api.IndicatorEvent;

public interface TimeEvent<T extends TemporalAdjuster> extends IndicatorEvent{

	void onTime(T time);

}
