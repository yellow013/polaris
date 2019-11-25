package io.polaris.indicators.impl.sar;

import io.polaris.financial.Instrument;
import io.polaris.indicators.api.IndicatorTimePeriod;
import io.polaris.indicators.base.BaseTimePeriodIndicator;
import io.polaris.indicators.events.SarEvent;
import io.polaris.market.impl.BasicMarketData;

public final class SarIndicator extends BaseTimePeriodIndicator<SarPoint, SarEvent> {

	public SarIndicator(Instrument instrument, IndicatorTimePeriod period) {
		super(instrument, period);
		this.period = period;
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}


}
