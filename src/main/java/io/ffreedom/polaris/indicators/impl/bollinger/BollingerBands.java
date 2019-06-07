package io.ffreedom.polaris.indicators.impl.bollinger;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.base.AbstractTimePeriodIndicator;
import io.ffreedom.polaris.indicators.events.BollingerBandsEvent;
import io.ffreedom.polaris.indicators.impl.bollinger.point.BollingerBandsPoint;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public class BollingerBands extends AbstractTimePeriodIndicator<BollingerBandsPoint, BollingerBandsEvent> {

	public BollingerBands(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		super(instrument, period, cycle);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {

	}

	@Override
	protected void initPooledPoints(PointSet<BollingerBandsPoint> points) {
		// TODO Auto-generated method stub

	}

}
