package io.ffreedom.polaris.indicators.impl.ma;

import io.ffreedom.common.functional.Callback;
import io.ffreedom.polaris.indicators.impl.ma.base.MA;
import io.ffreedom.polaris.indicators.impl.ma.base.MAPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class EMA extends MA {

	public EMA(int period) {
		super(period);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MAPoint getPoint(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endPoint(MAPoint p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerEndPointEvent(Callback<MAPoint> callback) {
		throw new UnsupportedOperationException("default method registerEvent(callback) is abstract method.");

	}

	@Override
	public void startPoint(MAPoint p) {

	}

	@Override
	public void registerStartPointEvent(Callback<MAPoint> callback) {

	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
