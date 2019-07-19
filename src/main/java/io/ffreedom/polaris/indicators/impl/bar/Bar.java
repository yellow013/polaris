package io.ffreedom.polaris.indicators.impl.bar;

@Deprecated
public final class Bar {

	// 存储开高低收价格和成交量以及成交金额的字段
	private double open = Double.NaN;
	private double highest = Double.MIN_VALUE;
	private double lowest = Double.MAX_VALUE;
	private double close = Double.NaN;

	Bar() {
	}

	void onPrice(double price) {
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
