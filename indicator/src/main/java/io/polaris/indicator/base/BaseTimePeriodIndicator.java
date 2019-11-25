package io.polaris.indicators.base;

import io.polaris.datetime.serial.TimePeriodSerial;
import io.polaris.financial.Instrument;
import io.polaris.indicators.api.CalculationCycle;
import io.polaris.indicators.api.IndicatorEvent;
import io.polaris.indicators.api.IndicatorTimePeriod;
import io.polaris.indicators.api.Point;

public abstract class BaseTimePeriodIndicator<P extends Point<TimePeriodSerial>, E extends IndicatorEvent>
		extends BaseIndicator<P, E> {

	protected IndicatorTimePeriod period;
	protected CalculationCycle cycle;

	public BaseTimePeriodIndicator(Instrument instrument, IndicatorTimePeriod period) {
		this(instrument, period, CalculationCycle.ONLY_ONE);
	}

	public BaseTimePeriodIndicator(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		super(instrument);
		this.period = period;
		this.cycle = cycle;
		
	}

}
