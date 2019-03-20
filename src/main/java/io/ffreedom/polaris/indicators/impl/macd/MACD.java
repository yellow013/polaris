package io.ffreedom.polaris.indicators.impl.macd;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractIndicator;
import io.ffreedom.polaris.market.BasicMarketData;

public final class MACD extends AbstractIndicator<MacdPoint> {

	public MACD(Instrument instrument, IndicatorPeriod period) {
		super(instrument, period);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected PointSet<MacdPoint> initPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected MacdPoint initCurrentPoint() {
		// TODO Auto-generated method stub
		return null;
	}

}
