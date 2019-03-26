package io.ffreedom.polaris.indicators.impl;

import javax.annotation.Nonnull;

import org.eclipse.collections.api.list.MutableList;
import org.slf4j.Logger;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.common.log.CommonLoggerFactory;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.Indicator;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.Point;
import io.ffreedom.polaris.indicators.api.PointSet;

public abstract class AbstractIndicator<P extends Point<?, ?>> implements Indicator<P> {

	private MutableList<IndicatorEvent<P>> indicatorEvents = ECollections.newFastList();

	protected Instrument instrument;
	protected IndicatorPeriod period;
	protected IndicatorCycle cycle;

	protected PointSet<P> points;
	protected P currentPoint;

	protected Logger logger = CommonLoggerFactory.getLogger(getClass());

	public AbstractIndicator(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
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

	@Override
	public Instrument getInstrument() {
		return instrument;
	}

	@Override
	public IndicatorPeriod getPeriod() {
		return period;
	}

	@Override
	public void addIndicatorEvent(IndicatorEvent<P> event) {
		if (event != null)
			indicatorEvents.add(event);
	}

	@Override
	public void currentPointChanged(P p) {
		if (indicatorEvents.notEmpty())
			indicatorEvents.each(event -> event.onCurrentPointChanged(p));
		else
			logger.info("this.currentPointChanged callback is null.");
	}

	@Override
	public void startPoint(P p) {
		if (indicatorEvents.notEmpty())
			indicatorEvents.each(event -> event.onStartPoint(p));
		else
			logger.info("this.startPoint callback is null.");
	}

	@Override
	public void endPoint(P p) {
		if (indicatorEvents.notEmpty())
			indicatorEvents.each(event -> event.onEndPoint(p));
		else
			logger.error("this.endPoint callback is null.");
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
