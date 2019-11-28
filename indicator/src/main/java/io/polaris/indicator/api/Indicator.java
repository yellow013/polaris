package io.polaris.indicator.api;

import io.mercury.common.sequence.Serial;
import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.market.impl.BasicMarketData;

public interface Indicator<P extends Point<? extends Serial<?>>, E extends IndicatorEvent> {

	Instrument getInstrument();

	void onMarketData(BasicMarketData marketData);

	void addIndicatorEvent(E event);

	P getPoint(int index);

	P getFastPoint();

	P getCurrentPoint();

	PointSet<P> getPointSet();

}
