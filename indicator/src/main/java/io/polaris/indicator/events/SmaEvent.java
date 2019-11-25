package io.polaris.indicator.events;

import io.polaris.indicator.api.IndicatorEvent;
import io.polaris.indicator.impl.ma.SmaPoint;

public interface SmaEvent extends IndicatorEvent {

	void onCurrentPointAvgPriceChanged(SmaPoint point);

	void onStartSmaPoint(SmaPoint point);

	void onEndSmaPoint(SmaPoint point);

}
