package io.ffreedom.polaris.indicators.api;

import io.ffreedom.common.sequence.Serial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public interface Point<S extends Serial<S>> {

	int getIndex();

	Instrument getInstrument();

	S getSerial();

	void onMarketData(BasicMarketData marketData);

}
