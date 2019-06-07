package io.ffreedom.polaris.indicators.impl.ma;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.polaris.datetime.TimePeriodPool;
import io.ffreedom.polaris.datetime.XTimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.base.AbstractTimePeriodIndicator;
import io.ffreedom.polaris.indicators.events.SmaEvent;
import io.ffreedom.polaris.indicators.impl.ma.points.SmaPoint;
import io.ffreedom.polaris.indicators.structure.FixedLengthHistoryPriceRecorder;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public final class PooledSma extends AbstractTimePeriodIndicator<SmaPoint, SmaEvent> {

	private FixedLengthHistoryPriceRecorder historyPriceRecorder;

	public PooledSma(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		super(instrument, period, cycle);
	}

	public static PooledSma with(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		return new PooledSma(instrument, period, cycle);
	}

	@Override
	protected void initPooledPoints(PointSet<SmaPoint> points) {
		this.historyPriceRecorder = FixedLengthHistoryPriceRecorder.newRecorder(cycle);
		ImmutableSortedSet<XTimePeriod> timePeriodSet = TimePeriodPool.Singleton.getTimePeriodSet(period, instrument);
		int i = -1;
		for (XTimePeriod timePeriod : timePeriodSet)
			points.add(SmaPoint.with(++i, instrument, period, timePeriod, cycle, historyPriceRecorder));
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub
		
	}





}
