package io.polaris.indicator.base;

import io.polaris.financial.instrument.Instrument;
import io.polaris.indicator.api.CalculationCycle;
import io.polaris.indicator.api.IndicatorEvent;
import io.polaris.indicator.api.Point;
import io.polaris.vector.TimePeriod;
import io.polaris.vector.TimePeriodSerial;

public abstract class BaseTimePeriodIndicator<P extends Point<TimePeriodSerial>, E extends IndicatorEvent>
		extends BaseIndicator<P, E> {

	protected TimePeriod period;
	protected CalculationCycle cycle;

	public BaseTimePeriodIndicator(Instrument instrument, TimePeriod period) {
		this(instrument, period, CalculationCycle.ONLY_ONE);
	}

	public BaseTimePeriodIndicator(Instrument instrument, TimePeriod period, CalculationCycle cycle) {
		super(instrument);
		this.period = period;
		this.cycle = cycle;
		
	}

}
