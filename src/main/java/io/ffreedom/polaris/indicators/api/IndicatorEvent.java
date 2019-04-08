package io.ffreedom.polaris.indicators.api;

public interface IndicatorEvent<P extends Point<?, ?>> {

	void onCurrentPointChanged(P point);

	void onStartPoint(P point);

	void onEndPoint(P point);

}
