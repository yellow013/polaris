package io.ffreedom.polaris.indicators.events;

import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.impl.ma.point.EmaPoint;

public interface EmaEvent extends IndicatorEvent {

	void onCurrentEmaPointAvgPriceChanged(EmaPoint point);

	void onStartEmaPoint(EmaPoint point);

	void onEndEmaPoint(EmaPoint point);

}
