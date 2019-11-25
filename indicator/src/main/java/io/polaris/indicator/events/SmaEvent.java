package io.polaris.indicators.events;

import io.polaris.indicators.api.IndicatorEvent;
import io.polaris.indicators.impl.ma.SmaPoint;

public interface SmaEvent extends IndicatorEvent {

	void onCurrentPointAvgPriceChanged(SmaPoint point);

	void onStartSmaPoint(SmaPoint point);

	void onEndSmaPoint(SmaPoint point);

}
