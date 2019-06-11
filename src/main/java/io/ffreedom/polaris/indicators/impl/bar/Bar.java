package io.ffreedom.polaris.indicators.impl.bar;

public final class Bar {

	private double open = Double.NaN;
	private double highest = Double.MIN_VALUE;
	private double lowest = Double.MAX_VALUE;
	private double close = Double.NaN;

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

}