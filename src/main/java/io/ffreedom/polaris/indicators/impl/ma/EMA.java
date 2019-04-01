package io.ffreedom.polaris.indicators.impl.ma;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractIndicator;
import io.ffreedom.polaris.market.BasicMarketData;

public class EMA extends AbstractIndicator<EMAPoint> {

	public EMA(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		super(instrument, period, cycle);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected PointSet<EMAPoint> initPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected EMAPoint initCurrentPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isCurrentPointPeriod(BasicMarketData marketData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected EMAPoint generateNextPoint(EMAPoint currentPoint) {
		// TODO Auto-generated method stub
		return null;
	}

}
