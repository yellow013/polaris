package io.ffreedom.polaris.indicators.impl.ma;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.indicators.impl.AbstractIndicator;
import io.ffreedom.polaris.indicators.impl.FixedLengthHistoryPriceRecorder;
import io.ffreedom.polaris.indicators.pools.TimePeriodPool;
import io.ffreedom.polaris.market.BasicMarketData;

public final class SMA extends AbstractIndicator<SMAPoint> {

	private FixedLengthHistoryPriceRecorder historyPriceRecorder;

	public SMA(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		super(instrument, period);
		this.historyPriceRecorder = FixedLengthHistoryPriceRecorder.newRecorder(cycle);
	}

	public static SMA with(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		return new SMA(instrument, period, cycle);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		currentPoint.onMarketData(marketData);
	}

	@Override
	protected PointSet<SMAPoint> initPoints() {
		PointSet<SMAPoint> pointSet = PointSet.emptyPointSet(256);
		ImmutableSortedSet<TimePeriod> timePeriodSet = TimePeriodPool.Singleton.getTimePeriodSet(period, instrument);
		timePeriodSet.each(timePeriod -> pointSet.add(SMAPoint.with(period, timePeriod, historyPriceRecorder)));
		return pointSet;
	}

	@Override
	protected SMAPoint initCurrentPoint() {
		return points.getFirst();
	}

}
