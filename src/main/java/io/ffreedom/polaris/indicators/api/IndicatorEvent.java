package io.ffreedom.polaris.indicators.api;

public interface IndicatorEvent<P extends Point<?, ?>> {

	String getEventName();

	void onCurrentPointChanged(P point);

	void onStartPoint(P point);

	void onEndPoint(P point);

}
