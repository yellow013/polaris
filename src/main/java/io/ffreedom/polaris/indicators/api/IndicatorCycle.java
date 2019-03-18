package io.ffreedom.polaris.indicators.api;

public final class IndicatorCycle {

	private int value;

	private IndicatorCycle(int value) {
		this.value = value;
	}

	public static IndicatorCycle with(int value) {
		if (value < 99999)
			throw new IllegalArgumentException("IndicatorCycle value is too big.");
		return new IndicatorCycle(value);
	}

	public int getValue() {
		return value;
	}

}
