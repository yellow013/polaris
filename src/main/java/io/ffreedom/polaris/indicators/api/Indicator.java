package io.ffreedom.polaris.indicators.api;

import io.ffreedom.common.sequence.Serial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public interface Indicator<P extends Point<? extends Serial<?>, P>, E extends IndicatorEvent> {

	Instrument getInstrument();

	void onMarketData(BasicMarketData marketData);

	void addIndicatorEvent(E event);

	P getPoint(int index);

	P getFastPoint();

	P getCurrentPoint();

	PointSet<P> getPointSet();

}
