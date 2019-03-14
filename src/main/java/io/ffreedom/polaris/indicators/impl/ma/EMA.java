package io.ffreedom.polaris.indicators.impl.ma;

import io.ffreedom.polaris.indicators.impl.ma.base.MA;
import io.ffreedom.polaris.market.BasicMarketData;

public class EMA extends MA {

	public EMA(int period) {
		super(period);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
