package io.ffreedom.polaris.indicators.impl.ma;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractPooledIndicator;
import io.ffreedom.polaris.indicators.impl.FixedLengthHistoryPriceRecorder;
import io.ffreedom.polaris.indicators.impl.ma.point.SmaPoint;
import io.ffreedom.polaris.indicators.pools.TimePeriodPool;
import io.ffreedom.polaris.market.BasicMarketData;

public final class PooledSma extends AbstractPooledIndicator<SmaPoint> {

	private FixedLengthHistoryPriceRecorder historyPriceRecorder;

	public PooledSma(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		super(instrument, period, cycle);
	}

	public static PooledSma with(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		return new PooledSma(instrument, period, cycle);
	}

	@Override
	protected PointSet<SmaPoint> initPoints() {
		PointSet<SmaPoint> pointSet = PointSet.emptyPointSet(256);
		this.historyPriceRecorder = FixedLengthHistoryPriceRecorder.newRecorder(cycle);
		ImmutableSortedSet<TimePeriod> timePeriodSet = TimePeriodPool.Singleton.getTimePeriodSet(period, instrument);
		timePeriodSet.each(timePeriod -> pointSet.add(SmaPoint.with(period, timePeriod, cycle, historyPriceRecorder)));
		return pointSet;
	}

	@Override
	protected SmaPoint initCurrentPoint() {
		return points.getFirst();
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

}
