package io.ffreedom.polaris.indicators.impl.ma.base;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractIndicator;

public abstract class MA extends AbstractIndicator<MAPoint> {

	protected MACalculateContainer calculateContainer;

	protected MA(Instrument instrument, IndicatorPeriod period, MAPeriod maPeriod) {
		super(instrument, period);
		this.calculateContainer = MACalculateContainer.newContainer(maPeriod);
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
