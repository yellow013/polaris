package io.ffreedom.polaris.indicators.api;

public interface IndicatorEvent<P extends Point<?, ?>> {

	String getEventName();

	void onStartPoint(P p);

	void onEndPoint(P p);

}
