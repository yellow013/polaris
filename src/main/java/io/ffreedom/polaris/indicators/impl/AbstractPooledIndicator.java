package io.ffreedom.polaris.indicators.impl;

import javax.annotation.Nonnull;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.Point;
import io.ffreedom.polaris.indicators.api.PointSet;

public abstract class AbstractPooledIndicator<P extends Point<?, P>> extends AbstractIndicator<P> {

	public AbstractPooledIndicator(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		super(instrument, period, cycle);
		initPooledPoints(points);
		this.currentPoint = points.getFirst();
	}

	@Nonnull
	protected abstract void initPooledPoints(PointSet<P> points);

}
