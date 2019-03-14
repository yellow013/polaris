package io.ffreedom.polaris.indicators.impl.ma.base;

import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractIndicator;

public abstract class MA extends AbstractIndicator<MAPoint> {

	protected int period;
	protected MACalculateContainer calculateContainer;

	protected MA(int period) {
		this.period = period;
		this.calculateContainer = MACalculateContainer.newContainer(period);
	}

	@Override
	protected PointSet<MAPoint> initPoints() {
		PointSet<MAPoint> mas = PointSet.emptyPointSet(256);
		return mas;
	}

	@Override
	protected MAPoint initCurrentPoint() {
		return MAPoint.with(null, null, null);
	}

}
