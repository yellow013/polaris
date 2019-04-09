package io.ffreedom.polaris.indicators.impl;

import javax.annotation.Nonnull;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.Point;

public abstract class AbstractUnpooledIndicator<P extends Point<?, P>, E extends IndicatorEvent> extends AbstractIndicator<P, E> {

	public AbstractUnpooledIndicator(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		super(instrument, period, cycle);
		this.currentPoint = initFirstPoint();
		points.add(currentPoint);
	}

	@Nonnull
	protected abstract P initFirstPoint();

}
