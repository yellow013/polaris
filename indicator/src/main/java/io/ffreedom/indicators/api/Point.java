package io.ffreedom.indicators.api;

public interface Point<P, X, Y, T> extends Comparable<P>{

	X getXAxis();

	Y getYAxis();

	P onTick(T tick);

}
