package io.ffreedom.polaris.indicators.impl.sar;

import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractIndicator;
import io.ffreedom.polaris.market.BasicMarketData;

public class SAR extends AbstractIndicator<SARPoint> {

	@Override
	public void onMarketData(BasicMarketData marketData) {

	}

	@Override
	protected PointSet<SARPoint> initPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected SARPoint initCurrentPoint() {
		// TODO Auto-generated method stub
		return null;
	}

}
