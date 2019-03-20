package io.ffreedom.polaris.indicators.impl.ma;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractIndicator;
import io.ffreedom.polaris.market.BasicMarketData;

public final class SMA extends AbstractIndicator<SMAPoint> {

	public SMA(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		super(instrument, period);
	}

	public static SMA with(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		return new SMA(instrument, period, cycle);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		currentPoint.onMarketData(marketData);
	}

	@Override
	protected PointSet<SMAPoint> initPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected SMAPoint initCurrentPoint() {
		// TODO Auto-generated method stub
		return null;
	}

}
