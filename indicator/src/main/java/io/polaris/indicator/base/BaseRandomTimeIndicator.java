package io.polaris.indicator.base;

import io.polaris.financial.instrument.Instrument;
import io.polaris.indicator.api.CalculationCycle;
import io.polaris.indicator.api.IndicatorEvent;
import io.polaris.indicator.api.Point;
import io.polaris.vector.RandomTimeSerial;

public abstract class BaseRandomTimeIndicator<P extends Point<RandomTimeSerial>, E extends IndicatorEvent>
		extends BaseIndicator<P, E> {

	protected CalculationCycle cycle;

	public BaseRandomTimeIndicator(Instrument instrument) {
		this(instrument, CalculationCycle.ONLY_ONE);
	}

	public BaseRandomTimeIndicator(Instrument instrument, CalculationCycle cycle) {
		super(instrument);
		this.cycle = cycle;
	}

}
