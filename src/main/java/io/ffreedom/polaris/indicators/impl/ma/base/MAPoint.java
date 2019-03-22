package io.ffreedom.polaris.indicators.impl.ma.base;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.TimePeriodPoint;
import io.ffreedom.polaris.indicators.impl.HistoryPriceRecorder;

public abstract class MAPoint<P extends MAPoint<P>> extends TimePeriodPoint<P> {

	protected HistoryPriceRecorder historyPriceRecorder;
	protected double avgPrice;
	protected double lastPrice;

	protected MAPoint(IndicatorPeriod period, TimePeriod timePeriod, HistoryPriceRecorder historyPriceRecorder) {
		super(period, timePeriod);
		this.historyPriceRecorder = historyPriceRecorder;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public HistoryPriceRecorder getHistoryPriceRecorder() {
		return historyPriceRecorder;
	}

}
