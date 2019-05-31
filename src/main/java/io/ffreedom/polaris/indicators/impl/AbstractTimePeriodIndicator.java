package io.ffreedom.polaris.indicators.impl;

import javax.annotation.Nonnull;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.api.Point;
import io.ffreedom.polaris.indicators.api.PointSet;

public abstract class AbstractPooledIndicator<P extends Point<?, P>, E extends IndicatorEvent>
		extends AbstractIndicator<P, E> {

	protected IndicatorTimePeriod period;
	protected CalculationCycle cycle;

	public AbstractPooledIndicator(Instrument instrument) {
		this(instrument, null, null);
	}

	public AbstractPooledIndicator(Instrument instrument, IndicatorTimePeriod period) {
		this(instrument, period, null);
	}

	public AbstractPooledIndicator(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		super(instrument);
		this.period = period;
		this.cycle = cycle;
		initPooledPoints(points);
		this.currentPoint = points.getFirst();
	}

	@Nonnull
	protected abstract void initPooledPoints(PointSet<P> points);

}
