package io.ffreedom.polaris.indicators.impl.bar.event;

import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.impl.bar.point.Bar;

public interface BarIndicatorEvent extends IndicatorEvent<Bar> {

	void onCurrentBarChanged(Bar point);

	void onStartBar(Bar point);

	void onEndBar(Bar point);

	@Override
	default void onCurrentPointChanged(Bar point) {
		onCurrentBarChanged(point);
	}

	@Override
	default void onStartPoint(Bar point) {
		onStartBar(point);
	}

	@Override
	default void onEndPoint(Bar point) {
		onEndBar(point);
	}

}
