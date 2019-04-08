package io.ffreedom.polaris.indicators.impl;

import io.ffreedom.polaris.datetime.TimeStarted;
import io.ffreedom.polaris.financial.Instrument;

public abstract class TimeStartedPoint<Y extends TimeStartedPoint<Y>> extends AbstractPoint<TimeStarted, Y> {

	protected TimeStarted timeStarted;

	protected TimeStartedPoint(int index, Instrument instrument, TimeStarted timeStarted) {
		super(index, instrument);
		this.timeStarted = timeStarted;
	}

	@Override
	public TimeStarted getXAxis() {
		return timeStarted;
	}

	public TimeStarted getTimeStarted() {
		return timeStarted;
	}

}