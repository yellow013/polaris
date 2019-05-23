package io.ffreedom.polaris.indicators.events;

import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.impl.bar.point.TimeBar;

public interface TimeBarsEvent extends IndicatorEvent {

	void onCurrentTimeBarLastPriceChanged(TimeBar bar);

	void onCurrentTimeBarHighestPriceChanged(TimeBar bar);

	void onCurrentTimeBarLowestPriceChanged(TimeBar bar);

	void onStartTimeBar(TimeBar bar);

	void onEndTimeBar(TimeBar bar);

}
