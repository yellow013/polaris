package io.polaris.indicators.events;

import io.polaris.indicators.api.IndicatorEvent;
import io.polaris.indicators.impl.ma.EmaPoint;

public interface EmaEvent extends IndicatorEvent {

	void onCurrentEmaPointAvgPriceChanged(EmaPoint point);

	void onStartEmaPoint(EmaPoint point);

	void onEndEmaPoint(EmaPoint point);

}
