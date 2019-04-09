package io.ffreedom.polaris.indicators.impl.bar.point;

import org.eclipse.collections.api.list.primitive.MutableDoubleList;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.common.utils.DoubleUtil;
import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public final class TimeBar extends TimePeriodPoint<TimeBar> {

	private double open = Double.NaN;
	private double highest = Double.MIN_VALUE;
	private double lowest = Double.MAX_VALUE;
	private double close = Double.NaN;
	private double volumeSum = 0.0D;
	private double turnoverSum = 0.0D;
	private MutableDoubleList priceRecord = ECollections.newDoubleArrayList(64);

	private TimeBar(int index, Instrument instrument, IndicatorPeriod period, TimePeriod timePeriod) {
		super(index, instrument, period, timePeriod);
	}

	public static TimeBar with(int index, Instrument instrument, IndicatorPeriod period, TimePeriod timePeriod) {
		return new TimeBar(index, instrument, period, timePeriod);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		onPrice(marketData.getLastPrice());
		addVolumeSum(marketData.getVolume());
		addTurnoverSum(marketData.getTurnover());
	}

	@Override
	protected TimeBar thisPoint() {
		return this;
	}

	@Override
	public TimeBar generateNext() {
		return new TimeBar(index + 1, instrument, period,
				TimePeriod.with(timePeriod.getStartTime().plusSeconds(period.getSeconds()),
						timePeriod.getEndTime().plusSeconds(period.getSeconds())));
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
