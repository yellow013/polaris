package io.polaris.indicators.api;

import io.ffreedom.common.sequence.Serial;
import io.polaris.financial.Instrument;
import io.polaris.market.impl.BasicMarketData;

public interface Point<S extends Serial<S>> {

	int getIndex();

	Instrument getInstrument();

	S getSerial();

	void onMarketData(BasicMarketData marketData);

}
