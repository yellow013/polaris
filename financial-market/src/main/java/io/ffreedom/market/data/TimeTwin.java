package io.ffreedom.market.data;

import java.time.LocalDateTime;

import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.tuple.Tuples;

import io.ffreedom.common.datetime.TimeZone;

public class TimeTwin implements Comparable<TimeTwin> {

	private long serialNumber;

	private Twin<LocalDateTime> twin;

	private TimeTwin(Twin<LocalDateTime> twin) {
		this.twin = twin;
		setSerialNumber();
	}

	private void setSerialNumber() {
		this.serialNumber = getStartDateTime().toEpochSecond(TimeZone.UTC);
	}

	public static TimeTwin of(LocalDateTime startTime, LocalDateTime endTime) {
		return new TimeTwin(Tuples.twin(startTime, endTime));
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

	@Override
	public int compareTo(TimeTwin o) {
		return getStartDateTime().compareTo(o.getStartDateTime());
	}

}
