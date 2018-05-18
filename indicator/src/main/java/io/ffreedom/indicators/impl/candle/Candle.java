package io.ffreedom.indicators.impl.candle;

import java.time.LocalDateTime;

import io.ffreedom.financial.Instrument;
import io.ffreedom.indicators.api.IndicatorPeriod;
import io.ffreedom.indicators.api.Point;
import io.ffreedom.market.data.MarketData;

public final class Candle implements Comparable<Candle>, Point<LocalDateTime, Candle> {

	private LocalDateTime startDateTime;
	private Instrument instrument;
	private IndicatorPeriod period;
	private double open = Double.NaN;
	private double high = Double.MIN_VALUE;
	private double low = Double.MAX_VALUE;
	private double close = Double.NaN;
	private double volumeSum;
	private double turnoverSum;

	private Candle(LocalDateTime startDateTime, Instrument instrument, IndicatorPeriod period) {
		this.startDateTime = startDateTime;
		this.instrument = instrument;
		this.period = period;
	}

	public static Candle emptyCandle(LocalDateTime startDateTime, Instrument instrument, IndicatorPeriod period) {
		return new Candle(startDateTime, instrument, period);
	}

	private Candle(MarketData marketData, IndicatorPeriod period) {
		this(marketData.getTimeSeries().toLocalDateTime(), marketData.getInstrument(), period);
		onMarketData(marketData);
	}

	public static Candle withFirstMarketData(MarketData marketData, IndicatorPeriod period) {
		return new Candle(marketData, period);
	}

	@Override
	public void onMarketData(MarketData marketData) {
		onPrice(marketData.getLastPrice());
		addVolumeSum(marketData.getVolume());
		addTurnover(marketData.getTurnover());
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

	private void addVolumeSum(double volume) {
		this.volumeSum += volume;
	}

	private void addTurnover(double turnover) {
		this.turnoverSum += turnover;
	}

	@Override
	public LocalDateTime getXAxis() {
		return startDateTime;
	}

	@Override
	public Candle getYAxis() {
		return this;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public IndicatorPeriod getPeriod() {
		return period;
	}

	public Instrument getInstrument() {
		return instrument;
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

	public double getVolumeSum() {
		return volumeSum;
	}

	public double getTurnoverSum() {
		return turnoverSum;
	}

	@Override
	public int compareTo(Candle o) {
		return this.startDateTime.isBefore(o.startDateTime) ? -1 : startDateTime.isAfter(o.startDateTime) ? 1 : 0;
	}

}
