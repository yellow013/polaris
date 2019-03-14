package io.ffreedom.polaris.indicators.api;

import io.ffreedom.common.functional.Callback;
import io.ffreedom.polaris.market.BasicMarketData;

public interface Indicator<P extends Point<?, ?>> {

	void onMarketData(BasicMarketData marketData);

	void addStartPointEvent(Callback<P> callback);

	void addEndPointEvent(Callback<P> callback);

	void startPoint(P p);

	void endPoint(P p);

	int size();

	P getPoint(int index);

	P fastPoint();

	P currentPoint();

	PointSet<P> getPointSet();

}
