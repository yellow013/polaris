package io.mercury.polaris.indicator.base;

import io.mercury.polaris.financial.instrument.Instrument;
import io.mercury.polaris.vector.RandomTimeSerial;

public abstract class RandomTimePoint<Y extends RandomTimePoint<Y>> extends BasePoint<RandomTimeSerial> {

	protected RandomTimeSerial timeSerial;

	protected RandomTimePoint(int index, Instrument instrument, RandomTimeSerial timeSerial) {
		super(index, instrument);
		this.timeSerial = timeSerial;
	}

	@Override
	public RandomTimeSerial serial() {
		return timeSerial;
	}

}