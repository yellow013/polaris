package io.ffreedom.polaris.indicators.impl.bar;

import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.list.primitive.MutableLongList;

import io.ffreedom.common.collect.MutableLists;
import io.ffreedom.common.number.DoubleUtil;
import io.ffreedom.polaris.datetime.XTimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.TimePeriodPoint;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public final class TimeBar extends TimePeriodPoint<TimeBar> {

	private Bar bar = new Bar();

	// 总成交量
	private long volumeSum = 0L;

	// 总成交金额
	private double turnoverSum = 0.0D;

	private MutableDoubleList priceRecord = MutableLists.newDoubleArrayList(64);
	private MutableLongList volumeRecord = MutableLists.newLongArrayList(64);

	private TimeBar(int index, Instrument instrument, IndicatorTimePeriod period, XTimePeriod timePeriod) {
		super(index, instrument, period, timePeriod);
	}

	public static TimeBar with(int index, Instrument instrument, IndicatorTimePeriod period, XTimePeriod timePeriod) {
		return new TimeBar(index, instrument, period, timePeriod);
	}

	@Override
	protected TimeBar thisObj() {
		return this;
	}

	public TimeBar generateNext() {
		return new TimeBar(index + 1, instrument, period,
				XTimePeriod.with(timePeriod.getStartTime().plusSeconds(period.getSeconds()),
						timePeriod.getEndTime().plusSeconds(period.getSeconds())));
	}

	public Bar getBar() {
		return bar;
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		bar.onPrice(marketData.getLastPrice());
		priceRecord.add(marketData.getLastPrice());

		volumeSum += marketData.getVolume();
		volumeRecord.add(marketData.getVolume());

		turnoverSum = DoubleUtil.correction8(turnoverSum + marketData.getTurnover());
	}

}
