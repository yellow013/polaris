package io.ffreedom.polaris.indicators.impl.ma.base;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractIndicator;

public abstract class MA extends AbstractIndicator<MAPoint> {

	protected MACalculateContainer calculateContainer;

	protected MA(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		super(instrument, period);
		this.calculateContainer = MACalculateContainer.newContainer(cycle);
	}

	@Override
	protected PointSet<MAPoint> initPoints() {
		return PointSet.emptyPointSet(256);
	}

	@Override
	protected MAPoint initCurrentPoint() {
		return points.first();
	}

}
