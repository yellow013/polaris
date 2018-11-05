package io.ffreedom.indicators.api;

import io.ffreedom.market.MarketData;

public interface Point<X, Y> {

	X getXAxis();

	Y getYAxis();

	void onMarketData(MarketData marketData);

}
