package io.ffreedom.polaris.indicators.api;

import io.ffreedom.common.sequence.Serial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.market.BasicMarketData;

public interface Indicator<P extends Point<? extends Serial<?>, P>, E extends IndicatorEvent> {

	Instrument getInstrument();

	IndicatorPeriod getPeriod();

	void onMarketData(BasicMarketData marketData);

	void addIndicatorEvent(E event);

	int size();

	P getPoint(int index);

	P getFastPoint();

	P getCurrentPoint();

	PointSet<P> getPointSet();

}
