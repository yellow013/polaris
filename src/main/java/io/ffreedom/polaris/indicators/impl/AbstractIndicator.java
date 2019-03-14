package io.ffreedom.polaris.indicators.impl;

import org.eclipse.collections.api.list.MutableList;
import org.slf4j.Logger;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.common.functional.Callback;
import io.ffreedom.common.log.CommonLoggerFactory;
import io.ffreedom.polaris.indicators.api.Indicator;
import io.ffreedom.polaris.indicators.api.Point;

public abstract class AbstractIndicator<P extends Point<?, ?>> implements Indicator<P> {

	protected MutableList<Callback<P>> startPointEvents = ECollections.newFastList();
	protected MutableList<Callback<P>> endPointEvents = ECollections.newFastList();

	private Logger logger = CommonLoggerFactory.getLogger(getClass());

	protected MutableList<P> points;
	protected P lastPoint;

	public AbstractIndicator() {
		this.points = ECollections.newFastList();
		this.lastPoint = initLastPoint();
	}

	protected abstract P initLastPoint();

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
	public P getFastPoint() {
		if (points.size() == 0)
			return lastPoint;
		return points.get(0);
	}

	@Override
	public P getLastPoint() {
		return lastPoint;
	}

	@Override
	public int size() {
		return points.size();
	}

	@Override
	public P getPoint(int index) {
		if (points.size() == 0 || index >= points.size())
			return lastPoint;
		if (index < 0)
			return points.get(0);
		return points.get(index);
	}

	@Override
	public MutableList<P> getPoints() {
		return points;
	}

}
