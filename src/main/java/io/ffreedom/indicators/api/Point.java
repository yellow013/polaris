package io.ffreedom.indicators.api;

import io.ffreedom.market.BasicMarketData;

public interface Point<X, Y> {

	X getXAxis();

	Y getYAxis();

	void onMarketData(BasicMarketData marketData);

}
