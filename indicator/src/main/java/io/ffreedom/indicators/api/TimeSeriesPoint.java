package io.ffreedom.indicators.api;

import java.time.LocalDateTime;

public abstract class TimeSeriesPoint<Y extends TimeSeriesPoint<?>> implements Point<LocalDateTime, Y>, Comparable<Y> {

	private LocalDateTime startDateTime;

	protected TimeSeriesPoint(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	@Override
	public final LocalDateTime getXAxis() {
		return startDateTime;
	}

	@Override
	public final Y getYAxis() {
		return getInstance();
	}

	@Override
	public final int compareTo(Y o) {
		return startDateTime.compareTo(o.getXAxis());
	}

	protected abstract Y getInstance();

}