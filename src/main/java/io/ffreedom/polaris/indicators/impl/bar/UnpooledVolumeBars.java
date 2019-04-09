package io.ffreedom.polaris.indicators.impl.bar;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.events.VolumeBarsEvent;
import io.ffreedom.polaris.indicators.impl.AbstractUnpooledIndicator;
import io.ffreedom.polaris.indicators.impl.bar.point.VolumeBar;
import io.ffreedom.polaris.market.BasicMarketData;

public class UnpooledVolumeBars extends AbstractUnpooledIndicator<VolumeBar, VolumeBarsEvent> {

	public UnpooledVolumeBars(Instrument instrument, IndicatorPeriod period) {
		super(instrument, period, IndicatorCycle.with(1));
	}

	@Override
	protected VolumeBar initFirstPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected VolumeBar generateNextPoint(VolumeBar currentPoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isCurrentPointPeriod(BasicMarketData marketData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
