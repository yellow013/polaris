package io.ffreedom.polaris.indicators.impl.ma.points;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.FixedLengthHistoryPriceRecorder;
import io.ffreedom.polaris.indicators.impl.TimePeriodPoint;

public abstract class MaPoint<P extends MaPoint<P>> extends TimePeriodPoint<P> {

	protected FixedLengthHistoryPriceRecorder historyPriceRecorder;
	protected double avgPrice;
	protected double lastPrice;

	protected MaPoint(int index,Instrument instrument, IndicatorPeriod period, TimePeriod timePeriod,
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
