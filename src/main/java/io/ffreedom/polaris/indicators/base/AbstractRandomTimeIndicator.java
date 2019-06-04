package io.ffreedom.polaris.indicators.impl;

import javax.annotation.Nonnull;

import io.ffreedom.polaris.datetime.XRandomTime;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.api.Point;

public abstract class AbstractRandomTimeIndicator<P extends Point<XRandomTime, P>, E extends IndicatorEvent>
		extends AbstractIndicator<P, E> {

	protected CalculationCycle cycle;

	public AbstractRandomTimeIndicator(Instrument instrument) {
		this(instrument, CalculationCycle.ONLY_ONE);
	}

	public AbstractRandomTimeIndicator(Instrument instrument, CalculationCycle cycle) {
		super(instrument);
		this.cycle = cycle;
		this.currentPoint = initFirstPoint();
		points.add(currentPoint);
	}

	@Nonnull
	protected abstract P initFirstPoint();

}
