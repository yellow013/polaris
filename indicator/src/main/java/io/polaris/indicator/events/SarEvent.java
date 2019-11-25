package io.polaris.indicator.events;

import io.polaris.indicator.api.IndicatorEvent;
import io.polaris.indicator.impl.sar.SarPoint;

public interface SarEvent extends IndicatorEvent {

	void onCurrentSarChanged(SarPoint point);

	void onStartSar(SarPoint point);

	void onEndSar(SarPoint point);

}
