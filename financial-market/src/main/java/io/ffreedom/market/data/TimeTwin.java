package io.ffreedom.market.data;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.tuple.Tuples;

import io.ffreedom.common.datetime.TimeZone;

public class TimeTwin implements Comparable<TimeTwin> {

	private LocalDate tradingDay;
	private long serialNumber;

	private Twin<LocalDateTime> twin;

	private TimeTwin(LocalDate tradingDay, int serialNumber, Twin<LocalDateTime> twin) {
		this.tradingDay = tradingDay;
		this.twin = twin;
		setSerialNumber(serialNumber);
	}

	private void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber * 10000000000L + getStartDateTime().toEpochSecond(TimeZone.UTC);
	}

	public static TimeTwin of(LocalDate tradingDay, int serialNumber, LocalDateTime startTime, LocalDateTime endTime) {
		return new TimeTwin(tradingDay, serialNumber, Tuples.twin(startTime, endTime));
	}

	public Twin<LocalDateTime> getTwin() {
		return twin;
	}

	public LocalDateTime getStartDateTime() {
		return twin.getOne();
	}

	public LocalDateTime getEndDateTime() {
		return twin.getTwo();
	}

	public long getSerialNumber() {
		return serialNumber;
	}

	public LocalDate getTradingDay() {
		return tradingDay;
	}

	@Override
	public int compareTo(TimeTwin o) {
		return tradingDay.isBefore(o.tradingDay) ? -1
				: tradingDay.isAfter(o.tradingDay) ? 1
						: serialNumber < o.serialNumber ? -1 
								: serialNumber > o.serialNumber ? 1 
										: 0;
	}

	public static void main(String[] args) {

		System.out.println(2 * 10000000000L + LocalDateTime.now().toEpochSecond(TimeZone.UTC));
		System.out.println(LocalDateTime.now().toEpochSecond(TimeZone.UTC));

	}

}
