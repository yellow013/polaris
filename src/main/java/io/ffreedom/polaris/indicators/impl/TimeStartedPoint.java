package io.ffreedom.polaris.indicators.impl;

import java.time.LocalDateTime;

import io.ffreedom.polaris.datetime.TimeStarted;

public abstract class TimeStartedPoint<Y extends TimeStartedPoint<Y>> extends AbstractPoint<TimeStarted, Y> {

	protected TimeStarted timeStarted;

	protected TimeStartedPoint(int index, TimeStarted timeStarted) {
		super(index);
		this.timeStarted = timeStarted;
	}

	protected TimeStartedPoint(int index, LocalDateTime startTime) {
		this(index, TimeStarted.with(startTime));
	}

	@Override
	public TimeStarted getXAxis() {
		return timeStarted;
	}

	public TimeStarted getTimeStarted() {
		return timeStarted;
	}

}