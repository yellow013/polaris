package io.polaris.indicators.api;

import io.ffreedom.common.sequence.Serial;
import io.polaris.financial.Instrument;
import io.polaris.market.impl.BasicMarketData;

public interface Indicator<P extends Point<? extends Serial<?>>, E extends IndicatorEvent> {

	Instrument getInstrument();

	void onMarketData(BasicMarketData marketData);

	void addIndicatorEvent(E event);

	P getPoint(int index);

	P getFastPoint();

	P getCurrentPoint();

	PointSet<P> getPointSet();

}
