package io.polaris.indicator.impl.bar;

import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.list.primitive.MutableLongList;

import io.mercury.common.collections.MutableLists;
import io.mercury.common.number.DoubleArithmetic;
import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.market.impl.BasicMarketData;
import io.polaris.indicator.base.TimePeriodPoint;
import io.polaris.vector.TimePeriod;
import io.polaris.vector.TimePeriodSerial;

public final class TimeBar extends TimePeriodPoint<TimeBar> {

	// 存储开高低收价格和成交量以及成交金额的字段
	private double open = Double.NaN;
	private double highest = Double.MIN_VALUE;
	private double lowest = Double.MAX_VALUE;
	private double last = Double.NaN;

	// 总成交量
	private long volumeSum = 0L;

	// 总成交金额
	private double turnoverSum = 0.0D;

	private MutableDoubleList priceRecord = MutableLists.newDoubleArrayList(64);
	private MutableLongList volumeRecord = MutableLists.newLongArrayList(64);

	private TimeBar(int index, Instrument instrument, TimePeriod period, TimePeriodSerial timePeriod) {
		super(index, instrument, period, timePeriod);
	}

	public static TimeBar with(int index, Instrument instrument, TimePeriod period,
			TimePeriodSerial timePeriod) {
		return new TimeBar(index, instrument, period, timePeriod);
	}

	public TimeBar generateNext() {
		return new TimeBar(index + 1, instrument, period,
				TimePeriodSerial.with(serial.getStartTime().plusSeconds(period.getSeconds()),
						serial.getEndTime().plusSeconds(period.getSeconds())));
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

	public MutableDoubleList getPriceRecord() {
		return priceRecord;
	}

	public long getVolumeSum() {
		return volumeSum;
	}

	public MutableLongList getVolumeRecord() {
		return volumeRecord;
	}

	public double getTurnoverSum() {
		return turnoverSum;
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		onPrice(marketData.getLastPrice());
		priceRecord.add(marketData.getLastPrice());

		volumeSum += marketData.getVolume();
		volumeRecord.add(marketData.getVolume());

		turnoverSum = DoubleArithmetic.correction8(turnoverSum + marketData.getTurnover());
	}

}
