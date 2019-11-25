package io.polaris.indicator.impl.macd;

import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.market.impl.BasicMarketData;
import io.polaris.indicator.base.BaseTimePeriodIndicator;
import io.polaris.indicator.events.MacdEvent;
import io.polaris.vector.TimePeriod;

public final class MacdIndicator extends BaseTimePeriodIndicator<MacdPoint, MacdEvent> {

	public MacdIndicator(Instrument instrument, TimePeriod timePeriod) {
		super(instrument, timePeriod);
	}


	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub
	}

}
