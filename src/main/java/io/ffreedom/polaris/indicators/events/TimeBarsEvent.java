package io.ffreedom.polaris.indicators.events;

import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.impl.bar.point.TimeBar;

public interface TimeBarsEvent extends IndicatorEvent {

	void onCurrentBarLastPriceChanged(TimeBar bar);

	void onCurrentBarHighestPriceChanged(TimeBar bar);

	void onCurrentBarLowestPriceChanged(TimeBar bar);

	void onStartBar(TimeBar point);

	void onEndBar(TimeBar point);

}
