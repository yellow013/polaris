package io.ffreedom.polaris.indicators.impl.sar;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.base.BaseTimePeriodIndicator;
import io.ffreedom.polaris.indicators.events.SarEvent;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public class SarIndicator extends BaseTimePeriodIndicator<SarPoint, SarEvent> {

	public SarIndicator(Instrument instrument, IndicatorTimePeriod period) {
		super(instrument, period);
		this.period = period;
	}

	@Override
	protected void initPooledPoints(PointSet<SarPoint> points) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
