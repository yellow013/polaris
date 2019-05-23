package io.ffreedom.polaris.indicators.api;

import java.time.temporal.TemporalAdjuster;

public interface TimeEvent<T extends TemporalAdjuster> {

	void onTime(T time);

}
