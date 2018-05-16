package io.ffreedom.market.data;

public abstract class Quote implements Comparable<Quote> {

	private double price;
	private double volume;

	protected Quote(double price, double volume) {
		this.price = price;
		this.volume = volume;
	}

	public double getPrice() {
		return price;
	}

	public double getVolume() {
		return volume;
	}

	public abstract QuoteType getType();

}
