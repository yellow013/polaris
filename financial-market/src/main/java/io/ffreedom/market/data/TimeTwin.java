package io.ffreedom.market.data;

import java.time.LocalTime;

import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.tuple.Tuples;

public class TimeTwin {

	private Twin<LocalTime> twin;

	public TimeTwin(Twin<LocalTime> twin) {
		this.twin = twin;
	}

	public static TimeTwin of(LocalTime startTime, LocalTime endTime) {
		return new TimeTwin(Tuples.twin(startTime, endTime));
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

}
