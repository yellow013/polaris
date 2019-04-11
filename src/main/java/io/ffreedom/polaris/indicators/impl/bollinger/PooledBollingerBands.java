package io.ffreedom.polaris.indicators.impl.bollinger;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.events.BollingerBandsEvent;
import io.ffreedom.polaris.indicators.impl.AbstractPooledIndicator;
import io.ffreedom.polaris.indicators.impl.bollinger.point.BollingerBandsPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class PooledBollingerBands extends AbstractPooledIndicator<BollingerBandsPoint, BollingerBandsEvent> {

	public PooledBollingerBands(Instrument instrument, IndicatorPeriod period) {
		super(instrument, period, IndicatorCycle.with(1));
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {

	}

	@Override
	protected void initPooledPoints(PointSet<BollingerBandsPoint> points) {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isCurrentPointPeriod(BasicMarketData marketData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected BollingerBandsPoint generateNextPoint(BollingerBandsPoint currentPoint) {
		// TODO Auto-generated method stub
		return null;
	}

}
