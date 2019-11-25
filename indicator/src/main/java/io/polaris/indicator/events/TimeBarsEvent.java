package io.polaris.indicator.events;

import io.polaris.indicator.api.IndicatorEvent;
import io.polaris.indicator.impl.bar.TimeBar;

public interface TimeBarsEvent extends IndicatorEvent {

	void onCurrentTimeBarChanged(TimeBar bar);

	void onStartTimeBar(TimeBar bar);

	void onEndTimeBar(TimeBar bar);

}
