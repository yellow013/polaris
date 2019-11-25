package io.polaris.indicator.base;

import io.polaris.financial.instrument.Instrument;
import io.polaris.vector.RandomTimeSerial;

public abstract class RandomTimePoint<Y extends RandomTimePoint<Y>> extends BasePoint<RandomTimeSerial> {

	protected RandomTimeSerial datetime;

	protected RandomTimePoint(int index, Instrument instrument, RandomTimeSerial datetime) {
		super(index, instrument);
		this.datetime = datetime;
	}

	@Override
	public RandomTimeSerial getSerial() {
		return datetime;
	}

}