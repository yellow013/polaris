package io.ffreedom.polaris.indicators.impl;

import javax.annotation.Nonnull;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.api.Point;

public abstract class AbstractUnpooledIndicator<P extends Point<?, P>, E extends IndicatorEvent>
		extends AbstractIndicator<P, E> {

	protected IndicatorTimePeriod period;
	protected CalculationCycle cycle;

	public AbstractUnpooledIndicator(Instrument instrument) {
		this(instrument, null, null);
	}

	public AbstractUnpooledIndicator(Instrument instrument, IndicatorTimePeriod period) {
		this(instrument, period, null);
	}

	public AbstractUnpooledIndicator(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		super(instrument);
		this.period = period;
		this.cycle = cycle;
		this.currentPoint = initFirstPoint();
		points.add(currentPoint);
	}

	@Nonnull
	protected abstract P initFirstPoint();

}
