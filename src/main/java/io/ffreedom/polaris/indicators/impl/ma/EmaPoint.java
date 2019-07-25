package io.ffreedom.polaris.indicators.impl.ma;

import io.ffreedom.polaris.datetime.serial.TimePeriodSerial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.impl.ma.base.MaPoint;
import io.ffreedom.polaris.indicators.structure.FixedHistoryPriceRecorder;
import io.ffreedom.polaris.market.impl.BasicMarketData;

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
