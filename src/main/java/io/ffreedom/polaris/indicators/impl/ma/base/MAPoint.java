package io.ffreedom.polaris.indicators.impl.ma.base;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.TimePeriodPoint;
import io.ffreedom.polaris.indicators.impl.FixedLengthHistoryPriceRecorder;

public abstract class MAPoint<P extends MAPoint<P>> extends TimePeriodPoint<P> {

	protected FixedLengthHistoryPriceRecorder historyPriceRecorder;
	protected double avgPrice;
	protected double lastPrice;

	protected MAPoint(int index, IndicatorPeriod period, TimePeriod timePeriod,
			FixedLengthHistoryPriceRecorder historyPriceRecorder) {
		super(index, period, timePeriod);
		this.historyPriceRecorder = historyPriceRecorder;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public FixedLengthHistoryPriceRecorder getHistoryPriceRecorder() {
		return historyPriceRecorder;
	}

}
