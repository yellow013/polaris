package io.ffreedom.polaris.indicators.impl.ma;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.BaseTimePeriodIndicator;
import io.ffreedom.polaris.indicators.events.EmaEvent;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public final class EmaIndicator extends BaseTimePeriodIndicator<EmaPoint, EmaEvent> {

	public EmaIndicator(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		super(instrument, period);
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected EmaPoint initialize() {
		// TODO Auto-generated method stub
		return null;
	}

}
