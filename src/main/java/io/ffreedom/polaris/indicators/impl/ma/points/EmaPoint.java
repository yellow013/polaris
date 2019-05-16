package io.ffreedom.polaris.indicators.impl.ma.points;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.structure.FixedLengthHistoryPriceRecorder;
import io.ffreedom.polaris.market.BasicMarketData;

public class EmaPoint extends MaPoint<EmaPoint> {

	protected EmaPoint(int index, Instrument instrument, IndicatorTimePeriod period, TimePeriod timePeriod,
			FixedLengthHistoryPriceRecorder historyPriceRecorder) {
		super(index, instrument, period, timePeriod, historyPriceRecorder);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EmaPoint generateNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected EmaPoint thisObj() {
		return this;
	}

}
