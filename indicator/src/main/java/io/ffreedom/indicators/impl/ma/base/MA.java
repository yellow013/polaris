package io.ffreedom.indicators.impl.ma.base;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;

import io.ffreedom.indicators.api.Indicator;

public abstract class MA implements Indicator<MAPoint> {

	protected int period;

	protected MutableSet<MAPoint> calculateList;

	protected double calculateListSum;

	protected double calculateListAvgPrice;

	protected double lastMaPrice;

	protected LinkedList<MAPoint> points;

	protected MAPoint lastPoint;

	protected MA(int period) {
		this.period = period;
		//this.calculateList = new LimitedLine<>(period - 1);
		this.calculateList = UnifiedSet.newSet();
		calculateList.toSortedList();
		
		this.points = new LinkedList<>();
	}

	protected void updateCalculateListTotal() {
		// this.calculateListSum
	}

	protected void updateAvgPrice(double lastPrice) {
		this.lastMaPrice = (calculateListSum + lastPrice) / period;
	}

	@Override
	public MAPoint getLastPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MAPoint> getPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MAPoint getFastPoint() {
		// TODO Auto-generated method stub
		return null;
	}

}
