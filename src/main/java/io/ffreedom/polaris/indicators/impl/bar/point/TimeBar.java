package io.ffreedom.polaris.indicators.impl.bar.point;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.impl.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public final class TimeBar extends TimePeriodPoint<TimeBar> {

	private Bar bar = new Bar();

	private TimeBar(int index, Instrument instrument, IndicatorTimePeriod period, TimePeriod timePeriod) {
		super(index, instrument, period, timePeriod);
	}

	public static TimeBar with(int index, Instrument instrument, IndicatorTimePeriod period, TimePeriod timePeriod) {
		return new TimeBar(index, instrument, period, timePeriod);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		bar.onPrice(marketData.getLastPrice());
		bar.addVolumeSum(marketData.getVolume());
		bar.addTurnoverSum(marketData.getTurnover());
	}

	@Override
	protected TimeBar thisObj() {
		return this;
	}

	@Override
	public TimeBar generateNext() {
		return new TimeBar(index + 1, instrument, period,
				TimePeriod.with(timePeriod.getStartTime().plusSeconds(period.getSeconds()),
						timePeriod.getEndTime().plusSeconds(period.getSeconds())));
	}

	public Bar getBar() {
		return bar;
	}

}
