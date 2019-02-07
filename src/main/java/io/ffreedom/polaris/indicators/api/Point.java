package io.ffreedom.polaris.indicators.api;

import io.ffreedom.polaris.market.BasicMarketData;

public interface Point<X, Y> {

	X getXAxis();

	Y getYAxis();

	void onMarketData(BasicMarketData marketData);

}
