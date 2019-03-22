package io.ffreedom.polaris.indicators.api;

import io.ffreedom.common.sequence.Serial;
import io.ffreedom.polaris.market.BasicMarketData;

public interface Point<X extends Serial<X>, Y extends Point<?, ?>> {

	IndicatorPeriod getPeriod();

	X getXAxis();

	Y getYAxis();

	/**
	 * 用于生成一个与前已节点相关的新节点
	 * 
	 * @return
	 */
	Y generateNext();

	void onMarketData(BasicMarketData marketData);

}
