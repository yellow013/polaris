package io.ffreedom.polaris.indicators.impl.ma.base;

import io.ffreedom.polaris.indicators.impl.AbstractIndicator;

public abstract class MA extends AbstractIndicator<MAPoint> {

	protected int period;
	protected MACalculateContainer calculateContainer;

	protected MA(int period) {
		this.period = period;
		this.calculateContainer = MACalculateContainer.newContainer(period);
	}

	@Override
	protected void initPoints() {
		// TODO Auto-generated method stub

	}

	@Override
	protected MAPoint initCurrentPoint() {
		return MAPoint.with(null, null);
	}

}
