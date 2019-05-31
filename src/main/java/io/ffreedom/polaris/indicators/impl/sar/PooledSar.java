package io.ffreedom.polaris.indicators.impl.sar;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.events.SarEvent;
import io.ffreedom.polaris.indicators.impl.AbstractPooledIndicator;
import io.ffreedom.polaris.market.BasicMarketData;

public class PooledSar extends AbstractPooledIndicator<SarPoint, SarEvent> {

	private IndicatorTimePeriod period;

	public PooledSar(Instrument instrument, IndicatorTimePeriod period) {
		super(instrument);
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
