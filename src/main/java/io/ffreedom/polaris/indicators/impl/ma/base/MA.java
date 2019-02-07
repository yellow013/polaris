package io.ffreedom.indicators.impl.ma.base;

import java.util.Collection;

import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;

import io.ffreedom.indicators.api.Indicator;

public abstract class MA implements Indicator<MAPoint> {

	protected int period;

	protected MutableSortedSet<MAPoint> maPoints;

	protected MACalculateContainer calculateContainer;

	protected MAPoint lastPoint;

	protected MA(int period) {
		this.period = period;
		this.maPoints = TreeSortedSet.newSet();
		this.calculateContainer = MACalculateContainer.newContainer(period);
	}

	@Override
	public MAPoint getLastPoint() {
		return lastPoint;
	}

	@Override
	public Collection<MAPoint> getPoints() {
		return maPoints;
	}

	@Override
	public MAPoint getFastPoint() {
		return maPoints.first();
	}

}
