package io.ffreedom.polaris.indicators.impl.ma.points;

import io.ffreedom.polaris.datetime.XTimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.structure.FixedLengthHistoryPriceRecorder;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public class EmaPoint extends MaPoint<EmaPoint> {

	protected EmaPoint(int index, Instrument instrument, IndicatorTimePeriod period, XTimePeriod timePeriod,
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
	protected EmaPoint thisObj() {
		return this;
	}

	@Override
	protected void handleMarketData(BasicMarketData preMarketData) {
		// TODO Auto-generated method stub

	}

}
