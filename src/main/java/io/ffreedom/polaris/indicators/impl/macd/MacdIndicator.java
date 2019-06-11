package io.ffreedom.polaris.indicators.impl.macd;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.BaseTimePeriodIndicator;
import io.ffreedom.polaris.indicators.events.MacdEvent;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public final class MacdIndicator extends BaseTimePeriodIndicator<MacdPoint, MacdEvent> {

	public MacdIndicator(Instrument instrument, IndicatorTimePeriod timePeriod) {
		super(instrument, timePeriod);
	}

	@Override
	protected MacdPoint initialize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub
	}

}