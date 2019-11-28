package io.polaris.indicator.api;

import io.mercury.common.sequence.Serial;
import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.market.impl.BasicMarketData;

public interface Point<S extends Serial<S>> {

	int getIndex();

	Instrument getInstrument();

	S getSerial();

	void onMarketData(BasicMarketData marketData);

}
