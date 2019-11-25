package io.polaris.indicator.impl.ma;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.market.impl.BasicMarketData;
import io.polaris.financial.time.TimePeriodPool;
import io.polaris.indicator.api.CalculationCycle;
import io.polaris.indicator.base.BaseTimePeriodIndicator;
import io.polaris.indicator.events.SmaEvent;
import io.polaris.indicator.structure.FixedHistoryPriceRecorder;
import io.polaris.vector.TimePeriod;
import io.polaris.vector.TimePeriodSerial;

public final class SmaIndicator extends BaseTimePeriodIndicator<SmaPoint, SmaEvent> {

	private FixedHistoryPriceRecorder historyPriceRecorder;

	public SmaIndicator(Instrument instrument, TimePeriod period, CalculationCycle cycle) {
		super(instrument, period, cycle);

		this.historyPriceRecorder = FixedHistoryPriceRecorder.newRecorder(cycle);
		ImmutableSortedSet<TimePeriodSerial> timePeriodSet = TimePeriodPool.Singleton.getTimePeriodSet(period, instrument);
		int i = -1;
		for (TimePeriodSerial timePeriod : timePeriodSet)
			pointSet.add(SmaPoint.with(++i, instrument, period, timePeriod, cycle, historyPriceRecorder));
		currentPoint = pointSet.getFirst();

	}

	public static SmaIndicator with(Instrument instrument, TimePeriod period, CalculationCycle cycle) {
		return new SmaIndicator(instrument, period, cycle);
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
