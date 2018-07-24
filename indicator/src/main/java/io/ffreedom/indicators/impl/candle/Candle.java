package io.ffreedom.indicators.impl.candle;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.ffreedom.common.utils.DoubleUtil;
import io.ffreedom.financial.Instrument;
import io.ffreedom.indicators.api.IndicatorPeriod;
import io.ffreedom.indicators.api.TimeSeriesPoint;
import io.ffreedom.market.MarketData;
import io.ffreedom.market.TimeTwin;

public final class Candle extends TimeSeriesPoint<Candle> {

	private LocalDate tradingDay;
	private long serialNumber;

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
		super(startTime, endTime);
		this.tradingDay = tradingDay;
		this.serialNumber = serialNumber;
		this.instrument = instrument;
		this.period = period;
	}

	private Candle(TimeTwin timeTwin, Instrument instrument, IndicatorPeriod period) {
		this(timeTwin.getTradingDay(), timeTwin.getSerialNumber(), timeTwin.getStartDateTime(),
				timeTwin.getEndDateTime(), instrument, period);
	}

	public static Candle withTimeTwin(TimeTwin timeTwin, Instrument instrument, IndicatorPeriod period) {
		return new Candle(timeTwin, instrument, period);
	}

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

	public LocalDate getTradingDay() {
		return tradingDay;
	}

	public long getSerialNumber() {
		return serialNumber;
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
