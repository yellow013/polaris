package io.ffreedom.polaris.indicators.events;

import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.impl.ma.points.SmaPoint;

public interface SmaEvent extends IndicatorEvent {

	void onCurrentPointAvgPriceChanged(SmaPoint point);

	void onStartSmaPoint(SmaPoint point);

	void onEndSmaPoint(SmaPoint point);

}
