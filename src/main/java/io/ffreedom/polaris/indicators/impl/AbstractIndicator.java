package io.ffreedom.polaris.indicators.impl;

import org.eclipse.collections.api.list.MutableList;
import org.slf4j.Logger;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.common.functional.Callback;
import io.ffreedom.common.log.CommonLoggerFactory;
import io.ffreedom.polaris.indicators.api.Indicator;
import io.ffreedom.polaris.indicators.api.Point;
import io.ffreedom.polaris.indicators.api.PointSet;

public abstract class AbstractIndicator<P extends Point<?, ?>> implements Indicator<P> {

	protected MutableList<Callback<P>> startPointEvents = ECollections.newFastList();
	protected MutableList<Callback<P>> endPointEvents = ECollections.newFastList();

	private Logger logger = CommonLoggerFactory.getLogger(getClass());

	protected PointSet<P> points;

	// protected MutableList<P> points;
	protected P currentPoint;

	public AbstractIndicator() {
		this(512);
	}

	public AbstractIndicator(int size) {
		this.points = PointSet.emptyPointSet(size);
		initPoints();
		this.currentPoint = initCurrentPoint();
	}

	protected abstract void initPoints();

	protected abstract P initCurrentPoint();

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
		if (endPointEvents.size() != 0) {
			endPointEvents.each(callback -> callback.onEvent(p));
		} else
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
