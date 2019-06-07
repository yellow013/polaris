package io.ffreedom.polaris.indicators.impl.macd;

import io.ffreedom.polaris.datetime.XTimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.TimePeriodPoint;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public class MacdPoint extends TimePeriodPoint<MacdPoint> {

	private MacdPoint(int index, Instrument instrument, IndicatorTimePeriod period, XTimePeriod timePeriod) {
		super(index, instrument, period, timePeriod);
	}

	@Override
	public MacdPoint generateNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected MacdPoint thisObj() {
		return this;
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
