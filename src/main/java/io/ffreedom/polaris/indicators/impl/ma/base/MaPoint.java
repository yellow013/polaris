package io.ffreedom.polaris.indicators.impl.ma.base;

import io.ffreedom.polaris.datetime.XTimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.TimePeriodPoint;
import io.ffreedom.polaris.indicators.structure.FixedLengthHistoryPriceRecorder;

public abstract class MaPoint<P extends MaPoint<P>> extends TimePeriodPoint<P> {

	protected FixedLengthHistoryPriceRecorder historyPriceRecorder;
	protected double avgPrice;
	protected double lastPrice;

	protected MaPoint(int index, Instrument instrument, IndicatorTimePeriod period, XTimePeriod timePeriod,
			FixedLengthHistoryPriceRecorder historyPriceRecorder) {
		super(index, instrument, period, timePeriod);
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
