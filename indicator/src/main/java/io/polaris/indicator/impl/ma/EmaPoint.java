package io.polaris.indicator.impl.ma;

import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.market.impl.BasicMarketData;
import io.polaris.indicator.impl.ma.base.MaPoint;
import io.polaris.indicator.structure.FixedHistoryPriceRecorder;
import io.polaris.vector.TimePeriod;
import io.polaris.vector.TimePeriodSerial;

public final class EmaPoint extends MaPoint<EmaPoint> {

	protected EmaPoint(int index, Instrument instrument, TimePeriod period, TimePeriodSerial timePeriod,
			FixedHistoryPriceRecorder historyPriceRecorder) {
		super(index, instrument, period, timePeriod, historyPriceRecorder);
		// TODO Auto-generated constructor stub
	}



	@Override
	protected void handleMarketData(BasicMarketData preMarketData) {
		// TODO Auto-generated method stub

	}

}
