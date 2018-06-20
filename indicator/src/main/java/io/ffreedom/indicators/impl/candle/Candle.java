package io.ffreedom.indicators.impl.candle;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.ffreedom.common.utils.DoubleUtil;
import io.ffreedom.financial.Instrument;
import io.ffreedom.indicators.api.IndicatorPeriod;
import io.ffreedom.indicators.api.TimeSeriesPoint;
import io.ffreedom.market.data.MarketData;
import io.ffreedom.market.data.TimeTwin;

public final class Candle extends TimeSeriesPoint<Candle> {

	private Instrument instrument;
	private IndicatorPeriod period;
	private double open = Double.NaN;
	private double high = Double.MIN_VALUE;
	private double low = Double.MAX_VALUE;
	private double close = Double.NaN;
	private double volumeSum = 0.0D;
	private double turnoverSum = 0.0D;

	private Candle(LocalDate tradingDay, long serialNumber, LocalDateTime startTime, LocalDateTime endTime,
			Instrument instrument, IndicatorPeriod period) {
		super(tradingDay, serialNumber, startTime, endTime);
		this.instrument = instrument;
		this.period = period;
	}

	private Candle(LocalDate tradingDay, TimeTwin timeTwin, Instrument instrument, IndicatorPeriod period) {
		this(tradingDay, timeTwin.getSerialNumber(), timeTwin.getStartDateTime(), timeTwin.getEndDateTime(), instrument,
				period);
	}

	public static Candle withTimeTwin(LocalDate tradingDay, TimeTwin timeTwin, Instrument instrument,
			IndicatorPeriod period) {
		return new Candle(tradingDay, timeTwin, instrument, period);
	}

	// private Candle(MarketData marketData, IndicatorPeriod period) {
	// this(marketData.getDatetime(), marketData.getInstrument(), period);
	// onMarketData(marketData);
	// }

	// public static Candle withFirstMarketData(MarketData marketData,
	// IndicatorPeriod period) {
	// return new Candle(marketData, period);
	// }

	@Override
	public void onMarketData(MarketData marketData) {
		onPrice(marketData.getLastPrice());
		addVolumeSum(marketData.getVolume());
		addTurnoverSum(marketData.getTurnover());
	}

	@Override
	protected Candle getThis() {
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
		this.volumeSum = DoubleUtil.correction(volumeSum + volume);
	}

	private void addTurnoverSum(double turnover) {
		this.turnoverSum = DoubleUtil.correction(turnoverSum + turnover);
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
