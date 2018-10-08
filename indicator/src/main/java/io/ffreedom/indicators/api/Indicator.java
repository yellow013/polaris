package io.ffreedom.indicators.api;

import java.util.Collection;

import io.ffreedom.common.functional.Callback;
import io.ffreedom.market.MarketData;

public interface Indicator<P extends Point<?, ?>> {

	void onMarketData(MarketData marketData);

	default void registerEvent(Callback<P> callback) {
		throw new UnsupportedOperationException("default method registerEvent(callback) is abstract method.");
	}

	void endPoint(P p);

	int size();

	P getPoint(int index);

	P getFastPoint();

	P getLastPoint();

	Collection<P> getPoints();

}
