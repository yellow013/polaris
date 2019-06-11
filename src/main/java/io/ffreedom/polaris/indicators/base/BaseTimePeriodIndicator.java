package io.ffreedom.polaris.indicators.base;

import io.ffreedom.polaris.datetime.XTimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.api.Point;

public abstract class BaseTimePeriodIndicator<P extends Point<XTimePeriod, P>, E extends IndicatorEvent>
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
		this.currentPoint = initialize();
	}

}