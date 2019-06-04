package io.ffreedom.polaris.indicators.impl.ma;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.base.AbstractTimePeriodIndicator;
import io.ffreedom.polaris.indicators.events.EmaEvent;
import io.ffreedom.polaris.indicators.impl.ma.points.EmaPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class PooledEma extends AbstractTimePeriodIndicator<EmaPoint, EmaEvent> {

	public PooledEma(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		super(instrument, period);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initPooledPoints(PointSet<EmaPoint> points) {
		// TODO Auto-generated method stub

	}

}
