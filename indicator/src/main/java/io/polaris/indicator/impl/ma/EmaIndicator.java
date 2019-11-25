package io.polaris.indicators.impl.ma;

import io.polaris.financial.Instrument;
import io.polaris.indicators.api.CalculationCycle;
import io.polaris.indicators.api.IndicatorTimePeriod;
import io.polaris.indicators.base.BaseTimePeriodIndicator;
import io.polaris.indicators.events.EmaEvent;
import io.polaris.market.impl.BasicMarketData;

public final class EmaIndicator extends BaseTimePeriodIndicator<EmaPoint, EmaEvent> {

	public EmaIndicator(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		super(instrument, period);
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}


}
