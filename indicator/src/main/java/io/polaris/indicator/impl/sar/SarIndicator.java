package io.polaris.indicator.impl.sar;

import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.market.impl.BasicMarketData;
import io.polaris.indicator.base.BaseTimePeriodIndicator;
import io.polaris.indicator.events.SarEvent;
import io.polaris.vector.TimePeriod;

public final class SarIndicator extends BaseTimePeriodIndicator<SarPoint, SarEvent> {

	public SarIndicator(Instrument instrument, TimePeriod period) {
		super(instrument, period);
		this.period = period;
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}


}
