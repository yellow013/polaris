package io.ffreedom.market;

abstract class Quotes implements Comparable<Quotes> {

	private double price;
	private double volume;

	protected Quotes(double price, double volume) {
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
