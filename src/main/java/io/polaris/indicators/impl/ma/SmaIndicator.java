package io.polaris.indicators.impl.ma;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.polaris.datetime.TimePeriodPool;
import io.polaris.datetime.serial.TimePeriodSerial;
import io.polaris.financial.Instrument;
import io.polaris.indicators.api.CalculationCycle;
import io.polaris.indicators.api.IndicatorTimePeriod;
import io.polaris.indicators.base.BaseTimePeriodIndicator;
import io.polaris.indicators.events.SmaEvent;
import io.polaris.indicators.structure.FixedHistoryPriceRecorder;
import io.polaris.market.impl.BasicMarketData;

public final class SmaIndicator extends BaseTimePeriodIndicator<SmaPoint, SmaEvent> {

	private FixedHistoryPriceRecorder historyPriceRecorder;

	public SmaIndicator(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		super(instrument, period, cycle);

		this.historyPriceRecorder = FixedHistoryPriceRecorder.newRecorder(cycle);
		ImmutableSortedSet<TimePeriodSerial> timePeriodSet = TimePeriodPool.Singleton.getTimePeriodSet(period, instrument);
		int i = -1;
		for (TimePeriodSerial timePeriod : timePeriodSet)
			pointSet.add(SmaPoint.with(++i, instrument, period, timePeriod, cycle, historyPriceRecorder));
		currentPoint = pointSet.getFirst();

	}

	public static SmaIndicator with(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		return new SmaIndicator(instrument, period, cycle);
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
