package io.ffreedom.polaris.indicators.api;

import io.ffreedom.common.sequence.Serial;
import io.ffreedom.polaris.market.BasicMarketData;

public interface Point<X extends Serial<X>, Y extends Point<?, ?>> {

	IndicatorPeriod getPeriod();

	X getXAxis();

	Y getYAxis();

	Y generateNext();

	void onMarketData(BasicMarketData marketData);

}
