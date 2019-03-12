package io.ffreedom.polaris.indicators.impl;

import org.slf4j.Logger;

import io.ffreedom.common.functional.Callback;
import io.ffreedom.common.log.CommonLoggerFactory;
import io.ffreedom.polaris.indicators.api.Indicator;
import io.ffreedom.polaris.indicators.api.Point;

public abstract class AbstractIndicator<P extends Point<?, ?>> implements Indicator<P> {

	protected Callback<P> startPointCallback;
	protected Callback<P> endPointCallback;

	private Logger logger = CommonLoggerFactory.getLogger(getClass());

	@Override
	public void endPoint(P p) {
		if (endPointCallback != null)
			endPointCallback.onEvent(p);
		else
			logger.error("this.endPointCallback is null.");
	}

	@Override
	public void registerEndPointEvent(Callback<P> callback) {
		this.endPointCallback = callback;
	}

	@Override
	public void startPoint(P p) {
		if (startPointCallback != null)
			startPointCallback.onEvent(p);
		else
			logger.info("this.startPointCallback is null.");
	}

	@Override
	public void registerStartPointEvent(Callback<P> callback) {
		this.startPointCallback = callback;
	}

}
