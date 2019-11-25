package io.polaris.indicators.impl.ma;

import io.polaris.datetime.serial.TimePeriodSerial;
import io.polaris.financial.Instrument;
import io.polaris.indicators.api.IndicatorTimePeriod;
import io.polaris.indicators.impl.ma.base.MaPoint;
import io.polaris.indicators.structure.FixedHistoryPriceRecorder;
import io.polaris.market.impl.BasicMarketData;

public final class EmaPoint extends MaPoint<EmaPoint> {

	protected EmaPoint(int index, Instrument instrument, IndicatorTimePeriod period, TimePeriodSerial timePeriod,
			FixedHistoryPriceRecorder historyPriceRecorder) {
		super(index, instrument, period, timePeriod, historyPriceRecorder);
		// TODO Auto-generated constructor stub
	}



	@Override
	protected void handleMarketData(BasicMarketData preMarketData) {
		// TODO Auto-generated method stub

	}

}
