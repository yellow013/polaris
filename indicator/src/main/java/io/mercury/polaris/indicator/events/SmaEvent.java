package io.mercury.polaris.indicator.events;

import io.mercury.polaris.indicator.api.IndicatorEvent;
import io.mercury.polaris.indicator.impl.ma.SmaPoint;

public interface SmaEvent extends IndicatorEvent {

	void onCurrentPointAvgPriceChanged(SmaPoint point);

	void onStartSmaPoint(SmaPoint point);

	void onEndSmaPoint(SmaPoint point);

}
