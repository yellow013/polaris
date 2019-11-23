package io.polaris.indicators.impl.bollinger;

import io.polaris.financial.Instrument;
import io.polaris.indicators.api.CalculationCycle;
import io.polaris.indicators.api.IndicatorTimePeriod;
import io.polaris.indicators.base.BaseTimePeriodIndicator;
import io.polaris.indicators.events.BollingerBandsEvent;
import io.polaris.market.impl.BasicMarketData;

public final class BollingerBandsIndicator extends BaseTimePeriodIndicator<BollingerBandsPoint, BollingerBandsEvent> {

	public BollingerBandsIndicator(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		super(instrument, period, cycle);
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {

	}

}
