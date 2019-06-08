package io.ffreedom.polaris.indicators.impl.sar;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.base.BaseTimePeriodIndicator;
import io.ffreedom.polaris.indicators.events.SarEvent;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public class Sar extends BaseTimePeriodIndicator<SarPoint, SarEvent> {

	public Sar(Instrument instrument, IndicatorTimePeriod period) {
		super(instrument, period);
		this.period = period;
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {

	}

	@Override
	protected void initPooledPoints(PointSet<SarPoint> points) {
		// TODO Auto-generated method stub

	}

}
