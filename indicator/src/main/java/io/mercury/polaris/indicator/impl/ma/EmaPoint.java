package io.mercury.polaris.indicator.impl.ma;

import io.mercury.polaris.financial.instrument.Instrument;
import io.mercury.polaris.financial.market.impl.BasicMarketData;
import io.mercury.polaris.indicator.impl.ma.base.MaPoint;
import io.mercury.polaris.indicator.structure.FixedHistoryPriceRecorder;
import io.mercury.polaris.vector.TimePeriod;
import io.mercury.polaris.vector.TimePeriodSerial;

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
