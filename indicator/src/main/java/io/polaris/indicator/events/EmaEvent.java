package io.polaris.indicator.events;

import io.polaris.indicator.api.IndicatorEvent;
import io.polaris.indicator.impl.ma.EmaPoint;

public interface EmaEvent extends IndicatorEvent {

	void onCurrentEmaPointAvgPriceChanged(EmaPoint point);

	void onStartEmaPoint(EmaPoint point);

	void onEndEmaPoint(EmaPoint point);

}
