package io.mercury.polaris.indicator.base;

import io.mercury.polaris.financial.instrument.Instrument;
import io.mercury.polaris.vector.RandomTimeSerial;

public abstract class RandomTimePoint<Y extends RandomTimePoint<Y>> extends BasePoint<RandomTimeSerial> {

	protected RandomTimeSerial datetime;

	protected RandomTimePoint(int index, Instrument instrument, RandomTimeSerial datetime) {
		super(index, instrument);
		this.datetime = datetime;
	}

	@Override
	public RandomTimeSerial serial() {
		return datetime;
	}

}