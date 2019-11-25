package io.polaris.indicators.base;

import io.polaris.datetime.serial.RandomTimeSerial;
import io.polaris.financial.Instrument;

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