package io.ffreedom.market.data;

import java.time.LocalTime;

import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.tuple.Tuples;

public class TimeTwin implements Comparable<TimeTwin> {

	private int serialNumber;

	private Twin<LocalTime> twin;

	private TimeTwin(int serialNumber, Twin<LocalTime> twin) {
		this.twin = twin;
		setSerialNumber(serialNumber);
	}

	private void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber * 100000 + getStartTime().toSecondOfDay();
	}

	public static TimeTwin of(int serialNumber, LocalTime startTime, LocalTime endTime) {
		return new TimeTwin(serialNumber, Tuples.twin(startTime, endTime));
	}

	public Twin<LocalTime> getTwin() {
		return twin;
	}

	public LocalTime getStartTime() {
		return twin.getOne();
	}

	public LocalTime getEndTime() {
		return twin.getTwo();
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	@Override
	public int compareTo(TimeTwin o) {
		return serialNumber > o.serialNumber ? -1 : 1;
	}

}
