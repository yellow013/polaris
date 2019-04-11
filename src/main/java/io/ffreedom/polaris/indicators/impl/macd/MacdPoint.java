package io.ffreedom.polaris.indicators.impl.macd;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class MacdPoint extends TimePeriodPoint<MacdPoint> {

	private MacdPoint(int index, Instrument instrument, IndicatorPeriod period, TimePeriod timePeriod) {
		super(index, instrument, period, timePeriod);
	}

	@Override
	public MacdPoint generateNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected MacdPoint thisObj() {
		return this;
	}

}
