package io.ffreedom.polaris.indicators.events;

import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.impl.sar.SarPoint;

public interface SarEvent extends IndicatorEvent {

	void onCurrentSarChanged(SarPoint point);

	void onStartSar(SarPoint point);

	void onEndSar(SarPoint point);

}
