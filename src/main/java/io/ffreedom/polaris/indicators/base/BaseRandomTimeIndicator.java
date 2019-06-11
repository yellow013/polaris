package io.ffreedom.polaris.indicators.base;

import io.ffreedom.polaris.datetime.RandomTimeSerial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.api.Point;

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
