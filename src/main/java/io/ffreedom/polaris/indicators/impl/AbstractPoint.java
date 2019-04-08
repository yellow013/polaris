package io.ffreedom.polaris.indicators.impl;

import io.ffreedom.common.sequence.Serial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.Point;

abstract class AbstractPoint<X extends Serial<X>, Y extends Point<X, Y>> implements Point<X, Y>, Comparable<Y> {

	protected int index;
	protected Instrument instrument;

	protected AbstractPoint(int index, Instrument instrument) {
		this.index = index;
		this.instrument = instrument;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public Instrument getInstrument() {
		return instrument;
	}

	@Override
	public Y getYAxis() {
		return thisPoint();
	}

	@Override
	public int compareTo(Y o) {
		return getXAxis().compareTo(o.getXAxis());
	}

	protected abstract Y thisPoint();

}
