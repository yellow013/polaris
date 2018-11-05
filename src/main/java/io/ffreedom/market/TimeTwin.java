package io.ffreedom.market;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.tuple.Tuples;

import io.ffreedom.common.datetime.TimeZones;

public class TimeTwin implements Comparable<TimeTwin> {

	private LocalDate tradingDay;
	private long serialNumber;

	private Twin<LocalDateTime> tradingTimeTwin;

	private TimeTwin(LocalDate tradingDay, int serialNumber, Twin<LocalDateTime> tradingTimeTwin) {
		this.tradingDay = tradingDay;
		this.tradingTimeTwin = tradingTimeTwin;
		setSerialNumber(serialNumber);
	}

	private void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber * 10000000000L + getStartDateTime().toEpochSecond(TimeZones.UTC);
	}

	public static TimeTwin of(LocalDate tradingDay, int serialNumber, LocalDateTime startTime, LocalDateTime endTime) {
		return new TimeTwin(tradingDay, serialNumber, Tuples.twin(startTime, endTime));
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
						: serialNumber < o.serialNumber ? -1 : serialNumber > o.serialNumber ? 1 : 0;
	}

	public static void main(String[] args) {

		System.out.println(2 * 10000000000L + LocalDateTime.now().toEpochSecond(TimeZones.UTC));
		System.out.println(LocalDateTime.now().toEpochSecond(TimeZones.UTC));

	}

}
