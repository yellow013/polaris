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
	private long currentVolume = 0L;

	private VolumeBar(int index, Instrument instrument, RandomTimeSerial timeStarted, long limitVolume) {
		super(index, instrument, timeStarted);
		this.limitVolume = limitVolume;
	}

	public static VolumeBar with(int index, Instrument instrument, LocalDateTime datetime, long limitVolume) {
		return new VolumeBar(index, instrument, RandomTimeSerial.with(datetime), limitVolume);
	}
	
	public static VolumeBar with(int index, Instrument instrument, RandomTimeSerial timeStarted, long limitVolume) {
		return new VolumeBar(index, instrument, RandomTimeSerial.with(timeStarted), limitVolume);
	}

	public long getLimitVolume() {
		return limitVolume;
	}

	public long getCurrentVolume() {
		return currentVolume;
	}

	public long getRemainingVolume() {
		return limitVolume - currentVolume;
	}

	public Bar getBar() {
		return bar;
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		handleData(marketData.getLastPrice(), marketData.getVolume());
	}

	public void handleData(double price, long volume) {
		if (limitVolume - currentVolume > volume)
			currentVolume += volume;
		else
			currentVolume = limitVolume;
		bar.onPrice(price);
	}

}
