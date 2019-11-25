package io.polaris.indicators.events;

import io.polaris.indicators.api.IndicatorEvent;
import io.polaris.indicators.impl.bar.TimeBar;

public interface TimeBarsEvent extends IndicatorEvent {

	void onCurrentTimeBarChanged(TimeBar bar);

	void onStartTimeBar(TimeBar bar);

	void onEndTimeBar(TimeBar bar);

}
