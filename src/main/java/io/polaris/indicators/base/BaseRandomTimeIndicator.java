package io.polaris.indicators.base;

import io.polaris.datetime.serial.RandomTimeSerial;
import io.polaris.financial.Instrument;
import io.polaris.indicators.api.CalculationCycle;
import io.polaris.indicators.api.IndicatorEvent;
import io.polaris.indicators.api.Point;

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
