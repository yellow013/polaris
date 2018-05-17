package io.ffreedom.indicators.impl.candle;

import java.time.LocalDateTime;

import javax.sound.midi.Instrument;

import io.ffreedom.indicators.api.IndicatorPeriod;
import io.ffreedom.indicators.api.TimeSeriesPoint;
import io.ffreedom.market.data.MarketData;

public class Candle implements TimeSeriesPoint<Candle, LocalDateTime, Candle, MarketData> {

	private LocalDateTime startDateTime;
	private LocalDateTime endDatetime;
	private IndicatorPeriod period;
	private Instrument instrument;
	private double open = Double.NaN;
	private double high = Double.MIN_VALUE;
	private double low = Double.MAX_VALUE;
	private double close = Double.NaN;
	private int volumeSum;

	private Candle() {
	}

	private Candle(double open) {
		onPrice(open);
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public Candle setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
		return this;
	}

	public LocalDateTime getEndDatetime() {
		return endDatetime;
	}

	public Candle setEndDatetime(LocalDateTime endDatetime) {
		this.endDatetime = endDatetime;
		return this;
	}

	public IndicatorPeriod getPeriod() {
		return period;
	}

	public Candle setPeriod(IndicatorPeriod period) {
		this.period = period;
		return this;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public Candle setInstrument(Instrument instrument) {
		this.instrument = instrument;
		return this;
	}

	public double getOpen() {
		return open;
	}

	public double getHigh() {
		return high;
	}

	public double getLow() {
		return low;
	}

	public double getClose() {
		return close;
	}

	public int getVolumeSum() {
		return volumeSum;
	}

	public static Candle withOpenPrice(double open) {
		return new Candle(open);
	}

	public static Candle emptyCandle() {
		return new Candle();
	}

	@Override
	public LocalDateTime getXAxis() {
		return this.startDateTime;
	}

	@Override
	public Candle getYAxis() {
		return this;
	}

	@Override
	public Candle onTick(MarketData tick) {
		// TODO 设置价格
		onPrice(0D);
		addVolumeSum(0);
		return this;
	}

	private void onPrice(double price) {
		close = price;
		if (open == Double.NaN) {
			open = price;
		}
		if (price < low) {
			low = price;
		}
		if (price > high) {
			high = price;
		}
	}

	private void addVolumeSum(int volume) {
		volumeSum += volume;
	}

	@Override
	public int compareTo(Candle o) {
		return this.startDateTime.isBefore(o.startDateTime) ? -1 : startDateTime.isAfter(o.startDateTime) ? 1 : 0;
	}

}
