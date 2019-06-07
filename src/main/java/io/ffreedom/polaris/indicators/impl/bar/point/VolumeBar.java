package io.ffreedom.polaris.indicators.impl.bar.point;

import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.XRandomTime;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.base.RandomTimePoint;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public class VolumeBar extends RandomTimePoint<VolumeBar> {

	private Bar bar = new Bar();

	private long volumeLimit;

	private VolumeBar(int index, Instrument instrument, XRandomTime timeStarted, long volumeLimit) {
		super(index, instrument, timeStarted);
		this.volumeLimit = volumeLimit;
	}

	public static VolumeBar with(int index, Instrument instrument, LocalDateTime datetime, long volumeLimit) {
		return new VolumeBar(index, instrument, XRandomTime.with(datetime), volumeLimit);
	}

	@Override
	public VolumeBar generateNext() {
		return null;
	}

	@Override
	protected VolumeBar thisObj() {
		return this;
	}

	public long getVolumeLimit() {
		return volumeLimit;
	}

	public Bar getBar() {
		return bar;
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {

	}

}
