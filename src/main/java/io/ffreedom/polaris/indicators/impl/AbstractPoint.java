package io.ffreedom.polaris.indicators.impl;

import io.ffreedom.common.sequence.Serial;
import io.ffreedom.polaris.indicators.api.Point;

public abstract class AbstractPoint<X extends Serial<X>, Y extends Point<X, Y>> implements Point<X, Y>, Comparable<Y> {

	private int index;

	protected AbstractPoint(int index) {
		this.index = index;
	}

	@Override
	public int getIndex() {
		return index;
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
