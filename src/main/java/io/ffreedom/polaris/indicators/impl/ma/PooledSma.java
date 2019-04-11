package io.ffreedom.polaris.indicators.impl.ma;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.events.SmaEvent;
import io.ffreedom.polaris.indicators.impl.AbstractPooledIndicator;
import io.ffreedom.polaris.indicators.impl.FixedLengthHistoryPriceRecorder;
import io.ffreedom.polaris.indicators.impl.ma.points.SmaPoint;
import io.ffreedom.polaris.indicators.pools.TimePeriodPool;
import io.ffreedom.polaris.market.BasicMarketData;

public final class PooledSma extends AbstractPooledIndicator<SmaPoint, SmaEvent> {

	private FixedLengthHistoryPriceRecorder historyPriceRecorder;

	public PooledSma(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		super(instrument, period, cycle);
	}

	public static PooledSma with(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		return new PooledSma(instrument, period, cycle);
	}

	@Override
	protected void initPooledPoints(PointSet<SmaPoint> points) {
		this.historyPriceRecorder = FixedLengthHistoryPriceRecorder.newRecorder(cycle);
		ImmutableSortedSet<TimePeriod> timePeriodSet = TimePeriodPool.Singleton.getTimePeriodSet(period, instrument);
		int i = -1;
		for (TimePeriod timePeriod : timePeriodSet)
			points.add(SmaPoint.with(++i, instrument, period, timePeriod, cycle, historyPriceRecorder));
	}

	@Override
	protected boolean isCurrentPointPeriod(BasicMarketData marketData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected SmaPoint generateNextPoint(SmaPoint currentPoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub
		
	}

}
