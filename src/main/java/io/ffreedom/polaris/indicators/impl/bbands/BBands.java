package io.ffreedom.polaris.indicators.impl.bbands;

import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractIndicator;
import io.ffreedom.polaris.market.BasicMarketData;

public class BBands extends AbstractIndicator<BBandsPoint> {

	@Override
	public void onMarketData(BasicMarketData marketData) {

	}

	@Override
	protected PointSet<BBandsPoint> initPoints() {
		return null;
	}

	@Override
	protected BBandsPoint initCurrentPoint() {
		return null;
	}

}
