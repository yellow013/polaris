package io.ffreedom.indicators.impl.candle;

import java.time.LocalDateTime;

import io.ffreedom.financial.Instrument;
import io.ffreedom.indicators.api.IndicatorPeriod;
import io.ffreedom.indicators.api.TimeSeriesPoint;
import io.ffreedom.market.data.MarketData;

import static io.ffreedom.common.utils.DoubleUtil.correction;

public final class Candle extends TimeSeriesPoint<Candle> {

	private Instrument instrument;
	private IndicatorPeriod period;
	private double open = Double.NaN;
	private double high = Double.MIN_VALUE;
	private double low = Double.MAX_VALUE;
	private double close = Double.NaN;
	private double volumeSum = 0.0D;
	private double turnoverSum = 0.0D;

	private Candle(LocalDateTime startDateTime, Instrument instrument, IndicatorPeriod period) {
		super(startDateTime);
		this.instrument = instrument;
		this.period = period;
	}

	public static Candle emptyCandle(LocalDateTime startDateTime, Instrument instrument, IndicatorPeriod period) {
		return new Candle(startDateTime, instrument, period);
	}

	private Candle(MarketData marketData, IndicatorPeriod period) {
		this(marketData.getDatetime(), marketData.getInstrument(), period);
		onMarketData(marketData);
	}

	public static Candle withFirstMarketData(MarketData marketData, IndicatorPeriod period) {
		return new Candle(marketData, period);
	}

	@Override
	public void onMarketData(MarketData marketData) {
		onPrice(marketData.getLastPrice());
		addVolumeSum(marketData.getVolume());
		addTurnoverSum(marketData.getTurnover());
	}

	@Override
	protected Candle getInstance() {
		return this;
	}

	private void onPrice(double price) {
		close = price;
		if (Double.isNaN(open)) {
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
		this.volumeSum = correction(volumeSum + volume);
	}

	private void addTurnoverSum(double turnover) {
		this.turnoverSum = correction(turnoverSum + turnover);
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

}
