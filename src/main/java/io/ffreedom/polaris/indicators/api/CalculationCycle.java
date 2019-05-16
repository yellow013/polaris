package io.ffreedom.polaris.indicators.api;

/**
 * 标识指标的一个点由N个周期的点计算而来
 * 
 * @author yellow013
 */
public final class CalculationCycle {

	private int cycleValue;

	private CalculationCycle(int cycleValue) {
		this.cycleValue = cycleValue;
	}

	public static CalculationCycle with(int cycleValue) {
		if (cycleValue > 9999)
			throw new IllegalArgumentException("IndicatorCycle value is too big.");
		return new CalculationCycle(cycleValue);
	}

	public int getCycleValue() {
		return cycleValue;
	}

}
