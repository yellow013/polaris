package io.ffreedom.polaris.indicators.api;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.market.BasicMarketData;

public interface Indicator<P extends Point<?, P>> {

	Instrument getInstrument();

	IndicatorPeriod getPeriod();

	void onMarketData(BasicMarketData marketData);

	void addIndicatorEvent(IndicatorEvent<P> event);

	void currentPointChanged(P p);

	void startPoint(P p);

	void endPoint(P p);

	int size();

	P getPoint(int index);

	P getFastPoint();

	P getCurrentPoint();

	PointSet<P> getPointSet();

}
