package io.ffreedom.indicators.impl.sar;

import java.util.Collection;

import io.ffreedom.common.functional.Callback;
import io.ffreedom.indicators.api.Indicator;
import io.ffreedom.market.BasicMarketData;

public class SAR implements Indicator<SARPoint> {

	@Override
	public void onMarketData(BasicMarketData marketData) {
		
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public SARPoint getPoint(int i) {
		return null;
	}

	@Override
	public Collection<SARPoint> getPoints() {
		return null;
	}

	@Override
	public SARPoint getFastPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SARPoint getLastPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endPoint(SARPoint p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerEndPointEvent(Callback<SARPoint> callback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startPoint(SARPoint p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerStartPointEvent(Callback<SARPoint> callback) {
		// TODO Auto-generated method stub
		
	}


}
