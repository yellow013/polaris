package io.ffreedom.polaris.indicators.base;

import io.ffreedom.polaris.datetime.RandomTimeSerial;
import io.ffreedom.polaris.financial.Instrument;

public abstract class RandomTimePoint<Y extends RandomTimePoint<Y>> extends BasePoint<RandomTimeSerial> {

	protected RandomTimeSerial timeStarted;

	protected RandomTimePoint(int index, Instrument instrument, RandomTimeSerial timeStarted) {
		super(index, instrument);
		this.timeStarted = timeStarted;
	}

	@Override
	public RandomTimeSerial getSerial() {
		return timeStarted;
	}

}