package io.polaris.indicator.impl.bar;

import java.time.LocalDateTime;

import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.market.impl.BasicMarketData;
import io.polaris.indicator.base.RandomTimePoint;
import io.polaris.vector.RandomTimeSerial;

public final class VolumeBar extends RandomTimePoint<VolumeBar> {

	// 存储开高低收价格和成交量以及成交金额的字段
	private double open = Double.NaN;
	private double highest = Double.MIN_VALUE;
	private double lowest = Double.MAX_VALUE;
	private double last = Double.NaN;

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

	public double getOpen() {
		return open;
	}

	public double getHighest() {
		return highest;
	}

	public double getLowest() {
		return lowest;
	}

	public double getLast() {
		return last;
	}

	private void onPrice(double price) {
		last = price;
		if (Double.isNaN(open))
			open = price;
		if (price < lowest)
			lowest = price;
		if (price > highest)
			highest = price;
	}
	
	public void initOpenPrice(double price) {
		if (Double.isNaN(open))
			open = price;
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

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		handleData(marketData.getLastPrice(), marketData.getVolume());
	}

	public void handleData(double price, long volume) {
		if (limitVolume - currentVolume > volume)
			currentVolume += volume;
		else
			currentVolume = limitVolume;
		onPrice(price);
	}

}
