package io.polaris.indicator.impl.ma.base;

import io.polaris.financial.instrument.Instrument;
import io.polaris.indicator.base.TimePeriodPoint;
import io.polaris.indicator.structure.FixedHistoryPriceRecorder;
import io.polaris.vector.TimePeriod;
import io.polaris.vector.TimePeriodSerial;

public abstract class MaPoint<P extends MaPoint<P>> extends TimePeriodPoint<P> {

	protected FixedHistoryPriceRecorder historyPriceRecorder;
	protected double avgPrice;
	protected double lastPrice;

	protected MaPoint(int index, Instrument instrument, TimePeriod period, TimePeriodSerial timePeriod,
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
