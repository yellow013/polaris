package io.ffreedom.polaris.indicators.impl;

import javax.annotation.Nonnull;

import org.eclipse.collections.api.list.MutableList;
import org.slf4j.Logger;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.common.functional.Callback;
import io.ffreedom.common.log.CommonLoggerFactory;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.Indicator;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.Point;
import io.ffreedom.polaris.indicators.api.PointSet;

public abstract class AbstractIndicator<P extends Point<?, ?>> implements Indicator<P> {

	private MutableList<Callback<P>> startPointEvents = ECollections.newFastList();
	private MutableList<Callback<P>> endPointEvents = ECollections.newFastList();

	protected Instrument instrument;
	protected IndicatorPeriod period;

	protected PointSet<P> points;
	protected P currentPoint;

	protected Logger logger = CommonLoggerFactory.getLogger(getClass());

	public AbstractIndicator(Instrument instrument, IndicatorPeriod period) {
		this.instrument = instrument;
		this.period = period;
		this.points = initPoints();
		this.currentPoint = initCurrentPoint();
	}

	@Nonnull
	protected abstract PointSet<P> initPoints();

	@Nonnull
	protected abstract P initCurrentPoint();

	@Override
	public Instrument getInstrument() {
		return instrument;
	}

	@Override
	public IndicatorPeriod getPeriod() {
		return period;
	}

	@Override
	public void addStartPointEvent(Callback<P> callback) {
		if (callback != null)
			this.startPointEvents.add(callback);
	}

	@Override
	public void addEndPointEvent(Callback<P> callback) {
		if (callback != null)
			this.endPointEvents.add(callback);
	}

	@Override
	public void startPoint(P p) {
		if (startPointEvents.size() > 0)
			startPointEvents.each(callback -> callback.onEvent(p));
		else
			logger.info("this.startPointCallback is null.");
	}

	@Override
	public void endPoint(P p) {
		if (endPointEvents.size() != 0)
			endPointEvents.each(callback -> callback.onEvent(p));
		else
			logger.error("this.endPointCallback is null.");
	}

	@Override
	public P fastPoint() {
		if (points.size() == 0)
			return currentPoint;
		return points.first();
	}

	@Override
	public P currentPoint() {
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
