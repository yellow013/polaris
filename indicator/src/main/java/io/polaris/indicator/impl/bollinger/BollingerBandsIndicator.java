package io.polaris.indicator.impl.bollinger;

import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.market.impl.BasicMarketData;
import io.polaris.indicator.api.CalculationCycle;
import io.polaris.indicator.base.BaseTimePeriodIndicator;
import io.polaris.indicator.events.BollingerBandsEvent;
import io.polaris.vector.TimePeriod;

public final class BollingerBandsIndicator extends BaseTimePeriodIndicator<BollingerBandsPoint, BollingerBandsEvent> {

	public BollingerBandsIndicator(Instrument instrument, TimePeriod period, CalculationCycle cycle) {
		super(instrument, period, cycle);
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {

	}

}
