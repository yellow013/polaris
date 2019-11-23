package io.polaris.indicators.events;

import io.polaris.indicators.api.IndicatorEvent;
import io.polaris.indicators.impl.sar.SarPoint;

public interface SarEvent extends IndicatorEvent {

	void onCurrentSarChanged(SarPoint point);

	void onStartSar(SarPoint point);

	void onEndSar(SarPoint point);

}
