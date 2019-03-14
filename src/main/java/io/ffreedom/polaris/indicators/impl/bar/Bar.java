package io.ffreedom.polaris.indicators.impl.bar;

import java.time.LocalDateTime;

import org.eclipse.collections.api.list.primitive.MutableDoubleList;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.common.utils.DoubleUtil;
import io.ffreedom.polaris.datetime.TimeTwin;
import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.TimeSeriesPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public final class Bar extends TimeSeriesPoint<Bar> {

	private Instrument instrument;
	private IndicatorPeriod period;

	private double open = Double.NaN;
	private double highest = Double.MIN_VALUE;
	private double lowest = Double.MAX_VALUE;
	private double close = Double.NaN;
	private double volumeSum = 0.0D;
	private double turnoverSum = 0.0D;
	private MutableDoubleList priceRecord = ECollections.newDoubleArrayList(64);

	private Bar(TradingDay tradingDay, LocalDateTime startTime, LocalDateTime endTime, Instrument instrument,
			IndicatorPeriod period) {
		super(tradingDay, startTime, endTime);
		this.instrument = instrument;
		this.period = period;
	}

	private Bar(TimeTwin timeTwin, Instrument instrument, IndicatorPeriod period) {
		this(timeTwin.getTradingDay(), timeTwin.getStartDateTime(), timeTwin.getEndDateTime(), instrument, period);
	}

	public static Bar with(TimeTwin timeTwin, Instrument instrument, IndicatorPeriod period) {
		return new Bar(timeTwin, instrument, period);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		onPrice(marketData.getLastPrice());
		addVolumeSum(marketData.getVolume());
		addTurnoverSum(marketData.getTurnover());
	}

	@Override
	protected Bar thisPoint() {
		return this;
	}

	private void onPrice(double price) {
		close = price;
		if (Double.isNaN(open))
			open = price;
		if (price < lowest)
			lowest = price;
		if (price > highest)
			highest = price;
		priceRecord.add(price);
	}

	private void addVolumeSum(double volume) {
		this.volumeSum = DoubleUtil.correction8(volumeSum + volume);
	}

	private void addTurnoverSum(double turnover) {
		this.turnoverSum = DoubleUtil.correction8(turnoverSum + turnover);
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

	public double getHighest() {
		return highest;
	}

	public double getLowest() {
		return lowest;
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

	public MutableDoubleList getPriceRecord() {
		return priceRecord;
	}

}
