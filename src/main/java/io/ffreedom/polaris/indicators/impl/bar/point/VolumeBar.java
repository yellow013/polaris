package io.ffreedom.polaris.indicators.impl.bar.point;

import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.TimeStarted;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.impl.TimeStartedPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class VolumeBar extends TimeStartedPoint<VolumeBar> {

	private Bar bar = new Bar();

	private double volumeLimit;

	private VolumeBar(int index, Instrument instrument, TimeStarted timeStarted, double volumeLimit) {
		super(index, instrument, timeStarted);
		this.volumeLimit = volumeLimit;
	}

	public static VolumeBar with(int index, Instrument instrument, LocalDateTime datetime, double volumeLimit) {
		return new VolumeBar(index, instrument, TimeStarted.with(datetime), volumeLimit);
	}

	@Override
	public VolumeBar generateNext() {
		return null;
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {

	}

	@Override
	protected VolumeBar thisObj() {
		return this;
	}

	public double getVolumeLimit() {
		return volumeLimit;
	}

	public Bar getBar() {
		return bar;
	}

}
