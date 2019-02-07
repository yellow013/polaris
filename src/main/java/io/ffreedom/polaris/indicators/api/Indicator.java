package io.ffreedom.polaris.indicators.api;

import java.util.Collection;

import io.ffreedom.common.functional.Callback;
import io.ffreedom.polaris.market.BasicMarketData;

public interface Indicator<P extends Point<?, ?>> {

	void onMarketData(BasicMarketData marketData);

	void endPoint(P p);

	void registerEndPointEvent(Callback<P> callback);

	void startPoint(P p);

	void registerStartPointEvent(Callback<P> callback);

	int size();

	P getPoint(int index);

	P getFastPoint();

	P getLastPoint();

	Collection<P> getPoints();

}
