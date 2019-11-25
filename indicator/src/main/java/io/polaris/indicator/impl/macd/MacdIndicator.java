package io.polaris.indicators.impl.macd;

import io.polaris.financial.Instrument;
import io.polaris.indicators.api.IndicatorTimePeriod;
import io.polaris.indicators.base.BaseTimePeriodIndicator;
import io.polaris.indicators.events.MacdEvent;
import io.polaris.market.impl.BasicMarketData;

public final class MacdIndicator extends BaseTimePeriodIndicator<MacdPoint, MacdEvent> {

	public MacdIndicator(Instrument instrument, IndicatorTimePeriod timePeriod) {
		super(instrument, timePeriod);
	}


	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub
	}

}
