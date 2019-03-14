package io.ffreedom.polaris.indicators.impl.ma.base;

public class MAPeriod {

	private int periodValue;

	public static MAPeriod with(int periodValue) {
		return new MAPeriod(periodValue);
	}

	public MAPeriod(int periodValue) {
		this.periodValue = periodValue;
	}

	public int getPeriodValue() {
		return periodValue;
	}

}
