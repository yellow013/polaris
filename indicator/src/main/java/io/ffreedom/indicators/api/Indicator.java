package io.ffreedom.indicators.api;

import java.util.Collection;

public interface Indicator<P extends Point<P, ?, ?, T>, T> {

	void onTick(T t);

	void onPoint(P p);

	int size();

	P getPoint(int i);

	default P getFastPoint() {
		return getPoint(0);
	}

	default P getLastPoint() {
		return getPoint(size() - 1);
	}

	Collection<P> getPoints();

}
