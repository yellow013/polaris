package io.polaris.indicator.impl.ma;

import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.market.impl.BasicMarketData;
import io.polaris.indicator.api.CalculationCycle;
import io.polaris.indicator.base.BaseTimePeriodIndicator;
import io.polaris.indicator.events.EmaEvent;
import io.polaris.vector.TimePeriod;

public final class EmaIndicator extends BaseTimePeriodIndicator<EmaPoint, EmaEvent> {

	public EmaIndicator(Instrument instrument, TimePeriod period, CalculationCycle cycle) {
		super(instrument, period);
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}


}
