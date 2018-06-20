package io.ffreedom.indicators.api;

import java.util.Collection;

import io.ffreedom.market.data.MarketData;

public interface Indicator<P extends Point<?, ?>> {
	
	void onMarketData(MarketData marketData);

	void endPoint(P p);

	int size();

	P getPoint(int index);

	P getFastPoint();

	P getLastPoint();

	Collection<P> getPoints();

}
