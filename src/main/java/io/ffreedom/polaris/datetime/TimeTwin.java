package io.ffreedom.polaris.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.tuple.Tuples;

import io.ffreedom.common.datetime.TimeZones;

public class TimeTwin implements Comparable<TimeTwin> {

	private LocalDate tradingDay;
	private long epochTime;
	private Twin<LocalDateTime> tradingTimeTwin;

	private TimeTwin(LocalDate tradingDay, Twin<LocalDateTime> tradingTimeTwin) {
		this.tradingDay = tradingDay;
		this.tradingTimeTwin = tradingTimeTwin;
		setEpochTime();
	}

	private void setEpochTime() {
		this.epochTime = getStartDateTime().toEpochSecond(TimeZones.UTC);
	}

	public static TimeTwin of(LocalDate tradingDay, LocalDateTime startTime, LocalDateTime endTime) {
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

	public LocalDate getTradingDay() {
		return tradingDay;
	}

	@Override
	public int compareTo(TimeTwin o) {
		return tradingDay.isBefore(o.tradingDay) ? -1
				: tradingDay.isAfter(o.tradingDay) ? 1 
						: epochTime < o.epochTime ? -1 
								: epochTime > o.epochTime ? 1 : 0;
	}

	public static void main(String[] args) {


	}

}
