package io.ffreedom.polaris.indicators.impl.bar;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.base.BaseRandomTimeIndicator;
import io.ffreedom.polaris.indicators.events.VolumeBarsEvent;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public class VolumeBarIndicator extends BaseRandomTimeIndicator<VolumeBar, VolumeBarsEvent> {

	public VolumeBarIndicator(Instrument instrument) {
		super(instrument);
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

}
