package io.ffreedom.polaris.indicators.impl.bbands;

import java.util.Collection;

import io.ffreedom.common.functional.Callback;
import io.ffreedom.polaris.indicators.api.Indicator;
import io.ffreedom.polaris.market.BasicMarketData;

public class BBands implements Indicator<BBandsPoint> {

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	public void endPoint(BBandsPoint p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerEndPointEvent(Callback<BBandsPoint> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void startPoint(BBandsPoint p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerStartPointEvent(Callback<BBandsPoint> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BBandsPoint getPoint(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BBandsPoint getFastPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BBandsPoint getLastPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<BBandsPoint> getPoints() {
		// TODO Auto-generated method stub
		return null;
	}

}
