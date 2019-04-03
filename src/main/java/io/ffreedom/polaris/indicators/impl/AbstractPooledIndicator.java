package io.ffreedom.polaris.indicators.impl;

import javax.annotation.Nonnull;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.Point;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.market.BasicMarketData;

public abstract class AbstractPooledIndicator<P extends Point<?, ?>> extends IndicatorEventManager<P> {

	protected Instrument instrument;
	protected IndicatorPeriod period;
	protected IndicatorCycle cycle;

	protected PointSet<P> points;
	protected P currentPoint;

	protected BasicMarketData preMarketData;

	public AbstractPooledIndicator(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		this.instrument = instrument;
		this.period = period;
		this.cycle = cycle;
		this.points = initPoints();
		this.currentPoint = initCurrentPoint();
	}

	@Nonnull
	protected abstract PointSet<P> initPoints();

	@Nonnull
	protected abstract P initCurrentPoint();

	@Nonnull
	protected abstract P generateNextPoint(P currentPoint);

	protected abstract boolean isCurrentPointPeriod(BasicMarketData marketData);

	@Override
	public void onMarketData(BasicMarketData marketData) {
		if (isCurrentPointPeriod(marketData)) {
			currentPoint.onMarketData(marketData);
		} else {
			endPoint(currentPoint);
			currentPoint = points.nextOf(currentPoint).orElseGet(() -> generateNextPoint(currentPoint));
			while (!isCurrentPointPeriod(marketData)) {
				currentPoint.onMarketData(preMarketData);
				startPoint(currentPoint);
				currentPoint = points.nextOf(currentPoint).orElseGet(() -> generateNextPoint(currentPoint));
			}
			currentPoint.onMarketData(marketData);
			startPoint(currentPoint);
		}
		this.preMarketData = marketData;
	}

	@Override
	public Instrument getInstrument() {
		return instrument;
	}

	@Override
	public IndicatorPeriod getPeriod() {
		return period;
	}

	@Override
	public P getFastPoint() {
		if (points.size() == 0)
			return currentPoint;
		return points.getFirst();
	}

	@Override
	public P getCurrentPoint() {
		return currentPoint;
	}

	@Override
	public int size() {
		return points.size();
	}

	@Override
	public P getPoint(int index) {
		if (index < 0 || points.size() == 0)
			return currentPoint;
		if (index >= points.size())
			index = points.size() - 1;
		return points.get(index).orElse(currentPoint);
	}

	@Override
	public PointSet<P> getPointSet() {
		return points;
	}

}
