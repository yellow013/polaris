package io.ffreedom.polaris.datetime;

import java.time.LocalDateTime;

import io.ffreedom.common.datetime.TimeZones;
import io.ffreedom.common.sequence.Serial;
import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;

public final class TimePeriod implements Serial<TimePeriod> {

	private TradingDay tradingDay;
	private long epochTime;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public static TimePeriod with(TradingDay tradingDay, LocalDateTime startTime, LocalDateTime endTime) {
		return new TimePeriod(tradingDay, startTime, endTime);
	}

	public TimePeriod(TradingDay tradingDay, LocalDateTime startTime, LocalDateTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		setEpochTime();
	}

	private void setEpochTime() {
		this.epochTime = getStartTime().toEpochSecond(TimeZones.UTC);
	}

	@Override
	public long getSerialNumber() {
		return epochTime;
	}

	@Override
	public int compareTo(TimePeriod o) {
		int compare = tradingDay.compareTo(o.tradingDay);
		if (compare == 0)
			return epochTime < o.epochTime ? -1 : epochTime > o.epochTime ? 1 : 0;
		return compare;
	}

	public TradingDay getTradingDay() {
		return tradingDay;
	}

	public long getEpochTime() {
		return epochTime;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

}
