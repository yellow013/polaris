package io.ffreedom.polaris.indicators.impl.bar.point;

import org.eclipse.collections.api.list.primitive.MutableDoubleList;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.common.utils.DoubleUtil;
import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public final class Bar extends TimePeriodPoint<Bar> {

	private Instrument instrument;

	private double open = Double.NaN;
	private double highest = Double.MIN_VALUE;
	private double lowest = Double.MAX_VALUE;
	private double close = Double.NaN;
	private double volumeSum = 0.0D;
	private double turnoverSum = 0.0D;
	private MutableDoubleList priceRecord = ECollections.newDoubleArrayList(64);

	private Bar(IndicatorPeriod period, TimePeriod timePeriod, Instrument instrument) {
		super(period, timePeriod);
		this.instrument = instrument;
	}

	public static Bar with(IndicatorPeriod period, TimePeriod timePeriod, Instrument instrument) {
		return new Bar(period, timePeriod, instrument);
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

	@Override
	public Bar generateNext() {
		return new Bar(period, TimePeriod.with(timePeriod.getStartTime().plusSeconds(period.getSeconds()),
				timePeriod.getEndTime().plusSeconds(period.getSeconds())), instrument);
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
