package io.ffreedom.indicators.api;

import java.time.temporal.TemporalAdjuster;

public interface TimeSeriesPoint<P extends TimeSeriesPoint<P, X, Y, T>, X extends TemporalAdjuster, Y, T>
		extends Point<P, X, Y, T> {
}