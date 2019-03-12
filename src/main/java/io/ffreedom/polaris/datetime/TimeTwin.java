package io.ffreedom.polaris.datetime;

import java.time.LocalDateTime;

import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.tuple.Tuples;

import io.ffreedom.common.datetime.TimeZones;
import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;

public class TimeTwin implements Comparable<TimeTwin> {

	private TradingDay tradingDay;
	private long epochTime;
	private Twin<LocalDateTime> tradingTimeTwin;

	private TimeTwin(TradingDay tradingDay, Twin<LocalDateTime> tradingTimeTwin) {
		this.tradingDay = tradingDay;
		this.tradingTimeTwin = tradingTimeTwin;
		setEpochTime();
	}

	private void setEpochTime() {
		this.epochTime = getStartDateTime().toEpochSecond(TimeZones.UTC);
	}

	public static TimeTwin of(TradingDay tradingDay, LocalDateTime startTime, LocalDateTime endTime) {
		return new TimeTwin(tradingDay, Tuples.twin(startTime, endTime));
	}

	public Twin<LocalDateTime> getTradingTimeTwin() {
		return tradingTimeTwin;
	}

	public LocalDateTime getStartDateTime() {
		return tradingTimeTwin.getOne();
	}

	public LocalDateTime getEndDateTime() {
		return tradingTimeTwin.getTwo();
	}

	public long getEpochTime() {
		return epochTime;
	}

	public TradingDay getTradingDay() {
		return tradingDay;
	}

	@Override
	public int compareTo(TimeTwin o) {
		int compare = tradingDay.compareTo(o.tradingDay);
		if (compare == 0)
			return epochTime < o.epochTime ? -1 : epochTime > o.epochTime ? 1 : 0;
		return compare;
	}

	public static void main(String[] args) {

	}

}
