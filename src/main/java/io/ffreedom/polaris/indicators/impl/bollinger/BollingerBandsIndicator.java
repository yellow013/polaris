package io.ffreedom.polaris.indicators.impl.bollinger;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.BaseTimePeriodIndicator;
import io.ffreedom.polaris.indicators.events.BollingerBandsEvent;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public final class BollingerBandsIndicator extends BaseTimePeriodIndicator<BollingerBandsPoint, BollingerBandsEvent> {

	public BollingerBandsIndicator(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		super(instrument, period, cycle);
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {

	}

	@Override
	protected BollingerBandsPoint initialize() {
		// TODO Auto-generated method stub
		return null;
	}

}
