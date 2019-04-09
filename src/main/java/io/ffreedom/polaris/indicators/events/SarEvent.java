package io.ffreedom.polaris.indicators.impl.sar.event;

import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.impl.sar.point.SarPoint;

public interface SarIndicatorEvent extends IndicatorEvent<SarPoint> {
	
	void onCurrentSarChanged(SarPoint point);

	void onStartSar(SarPoint point);

	void onEndSar(SarPoint point);

	@Override
	default void onCurrentPointChanged(SarPoint point) {
		onCurrentSarChanged(point);
	}

	@Override
	default void onStartPoint(SarPoint point) {
		onStartSar(point);
	}

	@Override
	default void onEndPoint(SarPoint point) {
		onEndSar(point);
	}

}
