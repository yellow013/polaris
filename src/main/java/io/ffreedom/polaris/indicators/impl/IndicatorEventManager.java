package io.ffreedom.polaris.indicators.impl;

import org.eclipse.collections.api.list.MutableList;
import org.slf4j.Logger;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.common.log.CommonLoggerFactory;
import io.ffreedom.polaris.indicators.api.Indicator;
import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.api.Point;

abstract class IndicatorEventManager<P extends Point<?, P>> implements Indicator<P> {

	protected Logger logger = CommonLoggerFactory.getLogger(getClass());

	private MutableList<IndicatorEvent<P>> indicatorEvents = ECollections.newFastList();

	@Override
	public void addIndicatorEvent(IndicatorEvent<P> event) {
		if (event != null)
			indicatorEvents.add(event);
	}

	@Override
	public void currentPointChanged(P p) {
		if (indicatorEvents.notEmpty())
			indicatorEvents.forEach(event -> event.onCurrentPointChanged(p));
		else
			logger.info("this.currentPointChanged callback is null.");
	}

	@Override
	public void startPoint(P p) {
		if (indicatorEvents.notEmpty())
			indicatorEvents.forEach(event -> event.onStartPoint(p));
		else
			logger.info("this.startPoint callback is null.");
	}

	@Override
	public void endPoint(P p) {
		if (indicatorEvents.notEmpty())
			indicatorEvents.forEach(event -> event.onEndPoint(p));
		else
			logger.error("this.endPoint callback is null.");
	}

}
