package io.ffreedom.polaris.indicators.impl.bar;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.base.AbstractRandomTimeIndicator;
import io.ffreedom.polaris.indicators.events.VolumeBarsEvent;
import io.ffreedom.polaris.indicators.impl.bar.point.VolumeBar;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public class VolumeBars extends AbstractRandomTimeIndicator<VolumeBar, VolumeBarsEvent> {

	public VolumeBars(Instrument instrument) {
		super(instrument);
	}

	@Override
	protected VolumeBar initFirstPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
