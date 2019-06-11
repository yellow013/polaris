package io.ffreedom.polaris.indicators.impl.bar;

import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.RandomTimeSerial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.base.RandomTimePoint;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public final class VolumeBar extends RandomTimePoint<VolumeBar> {

	// 存储开高低收价格和成交量以及成交金额的数据结构
	private Bar bar = new Bar();

	// 此bar限制的成交量
	private long limitVolume;

	// 当前已写入的成交量
	private long currentVolume;

	// 剩余的成交量
	private long remainingVolume;

	private VolumeBar(int index, Instrument instrument, RandomTimeSerial timeStarted, long limitVolume,
			long initCurrentVolume) {
		super(index, instrument, timeStarted);
		this.limitVolume = limitVolume;
		this.currentVolume = initCurrentVolume;
	}

	public static VolumeBar with(int index, Instrument instrument, LocalDateTime datetime, long limitVolume) {
		return new VolumeBar(index, instrument, RandomTimeSerial.with(datetime), limitVolume, 0);
	}

	public static VolumeBar with(int index, Instrument instrument, LocalDateTime datetime, long limitVolume,
			long initCurrentVolume) {
		return new VolumeBar(index, instrument, RandomTimeSerial.with(datetime), limitVolume, initCurrentVolume);
	}

	public long getLimitVolume() {
		return limitVolume;
	}

	public long getCurrentVolume() {
		return currentVolume;
	}

	public long getRemainingVolume() {
		return remainingVolume;
	}

	public Bar getBar() {
		return bar;
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		bar.onPrice(marketData.getLastPrice());
	}

}
