package io.ffreedom.polaris.indicators.impl.ma.base;

import java.util.Collection;

import org.eclipse.collections.api.list.MutableList;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.polaris.indicators.api.Indicator;

public abstract class MA implements Indicator<MAPoint> {

	protected int period;

	protected MutableList<MAPoint> maPoints;

	protected MACalculateContainer calculateContainer;

	protected MAPoint lastPoint;

	protected MA(int period) {
		this.period = period;
		this.maPoints = ECollections.newFastList();
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
		return maPoints.getFirst();
	}

}
