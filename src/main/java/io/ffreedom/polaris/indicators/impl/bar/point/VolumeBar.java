package io.ffreedom.polaris.indicators.impl.bar.point;

import io.ffreedom.polaris.datetime.TimeStarted;
import io.ffreedom.polaris.indicators.api.Point;
import io.ffreedom.polaris.market.BasicMarketData;

public class VolumeBar implements Point<TimeStarted, VolumeBar> {

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TimeStarted getXAxis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VolumeBar getYAxis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VolumeBar generateNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
