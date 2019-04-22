package io.ffreedom.polaris.indicators.impl.bar.point;

import org.eclipse.collections.api.list.primitive.MutableDoubleList;

import io.ffreedom.common.collect.MutableLists;
import io.ffreedom.common.utils.DoubleUtil;

public final class Bar {

	private double open = Double.NaN;
	private double highest = Double.MIN_VALUE;
	private double lowest = Double.MAX_VALUE;
	private double close = Double.NaN;
	private double volumeSum = 0.0D;
	private double turnoverSum = 0.0D;
	private MutableDoubleList priceRecord = MutableLists.newDoubleArrayList(64);

	Bar() {
	}

	public void onPrice(double price) {
		close = price;
		if (Double.isNaN(open))
			open = price;
		if (price < lowest)
			lowest = price;
		if (price > highest)
			highest = price;
		priceRecord.add(price);
	}

	public void addVolumeSum(double volume) {
		this.volumeSum = DoubleUtil.correction8(volumeSum + volume);
	}

	public void addTurnoverSum(double turnover) {
		this.turnoverSum = DoubleUtil.correction8(turnoverSum + turnover);
	}

	public double getOpen() {
		return open;
	}

	public double getHighest() {
		return highest;
	}

	public double getLowest() {
		return lowest;
	}

	public double getClose() {
		return close;
	}

	public double getVolumeSum() {
		return volumeSum;
	}

	public double getTurnoverSum() {
		return turnoverSum;
	}

	public MutableDoubleList getPriceRecord() {
		return priceRecord;
	}

}
