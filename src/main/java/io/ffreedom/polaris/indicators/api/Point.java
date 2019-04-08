package io.ffreedom.polaris.indicators.api;

import io.ffreedom.common.sequence.Serial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.market.BasicMarketData;

public interface Point<X extends Serial<X>, Y extends Point<X, Y>> {

	int getIndex();
	
	Instrument getInstrument();

	X getXAxis();

	Y getYAxis();

	/**
	 * 使用上一个节点生成新节点
	 * 
	 * @return
	 */
	Y generateNext();

	void onMarketData(BasicMarketData marketData);

}
