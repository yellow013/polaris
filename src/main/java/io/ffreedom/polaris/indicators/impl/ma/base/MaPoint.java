package io.ffreedom.polaris.indicators.impl.ma.base;

import io.ffreedom.polaris.datetime.serial.TimePeriodSerial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.TimePeriodPoint;
import io.ffreedom.polaris.indicators.structure.FixedHistoryPriceRecorder;

public abstract class MaPoint<P extends MaPoint<P>> extends TimePeriodPoint<P> {

	protected FixedHistoryPriceRecorder historyPriceRecorder;
	protected double avgPrice;
	protected double lastPrice;

	protected MaPoint(int index, Instrument instrument, IndicatorTimePeriod period, TimePeriodSerial timePeriod,
			FixedHistoryPriceRecorder historyPriceRecorder) {
		super(index, instrument, period, timePeriod);
		this.historyPriceRecorder = historyPriceRecorder;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public FixedHistoryPriceRecorder getHistoryPriceRecorder() {
		return historyPriceRecorder;
	}

}
