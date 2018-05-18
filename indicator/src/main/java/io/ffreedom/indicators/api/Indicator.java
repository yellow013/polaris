package io.ffreedom.indicators.api;

import java.util.Collection;

import io.ffreedom.market.data.MarketData;

public interface Indicator<P extends Point<?, ?>> {

	void onMarketData(MarketData marketData);

	void startPoint();
	
	void endPoint();

	int size();

	P getPoint(int i);

	default P getFastPoint() {
		return getPoint(0);
	}

	default P getLastPoint() {
		return getPoint(size() - 1);
	}

	Collection<P> getPoints();

}
