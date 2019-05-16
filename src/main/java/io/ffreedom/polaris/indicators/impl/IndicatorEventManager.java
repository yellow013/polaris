package io.ffreedom.polaris.indicators.impl;

import org.eclipse.collections.api.list.MutableList;
import org.slf4j.Logger;

import io.ffreedom.common.collect.MutableLists;
import io.ffreedom.common.log.CommonLoggerFactory;
import io.ffreedom.common.sequence.Serial;
import io.ffreedom.polaris.indicators.api.Indicator;
import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.api.Point;

public abstract class IndicatorEventManager<P extends Point<? extends Serial<?>, P>, E extends IndicatorEvent>
		implements Indicator<P, E> {

	protected Logger logger = CommonLoggerFactory.getLogger(getClass());

	private MutableList<E> indicatorEvents = MutableLists.newFastList();

	@Override
	public void addIndicatorEvent(E event) {
		if (event != null)
			indicatorEvents.add(event);
	}

}
