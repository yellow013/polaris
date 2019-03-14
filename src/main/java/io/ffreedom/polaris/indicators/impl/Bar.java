package io.ffreedom.polaris.indicators.impl;

import javax.annotation.concurrent.NotThreadSafe;

import io.ffreedom.common.datetime.TimePoint;

@NotThreadSafe
public final class Bar {

	private TimePoint startTimePoint;
	private TimePoint endTimePoint;
	
	private double startPrice = 0.0D;
	private double endPrice = 0.0D;
	private double highest = Double.MIN_VALUE;
	private double lowest = Double.MAX_VALUE;

}
