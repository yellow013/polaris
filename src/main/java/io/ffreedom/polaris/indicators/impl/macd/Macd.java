package io.ffreedom.polaris.indicators.impl.macd;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.base.BaseTimePeriodIndicator;
import io.ffreedom.polaris.indicators.events.MacdEvent;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public final class Macd extends BaseTimePeriodIndicator<MacdPoint, MacdEvent> {

	public Macd(Instrument instrument, IndicatorTimePeriod timePeriod) {
		super(instrument, timePeriod);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initPooledPoints(PointSet<MacdPoint> points) {
		// TODO Auto-generated method stub

	}

}
