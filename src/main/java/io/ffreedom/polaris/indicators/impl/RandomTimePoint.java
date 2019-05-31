package io.ffreedom.polaris.indicators.impl;

import io.ffreedom.polaris.datetime.XRandomTime;
import io.ffreedom.polaris.financial.Instrument;

public abstract class RandomTimePoint<Y extends RandomTimePoint<Y>> extends AbstractPoint<XRandomTime, Y> {

	protected XRandomTime timeStarted;

	protected RandomTimePoint(int index, Instrument instrument, XRandomTime timeStarted) {
		super(index, instrument);
		this.timeStarted = timeStarted;
	}

	@Override
	public XRandomTime getXAxis() {
		return timeStarted;
	}

}