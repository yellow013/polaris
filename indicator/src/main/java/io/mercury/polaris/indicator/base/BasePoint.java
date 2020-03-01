package io.mercury.polaris.indicator.base;

import io.mercury.common.annotation.lang.ProtectedAbstractMethod;
import io.mercury.common.sequence.Serial;
import io.mercury.polaris.financial.instrument.Instrument;
import io.mercury.polaris.financial.market.impl.BasicMarketData;
import io.mercury.polaris.indicator.api.Point;

abstract class BasePoint<S extends Serial<S>> implements Point<S>, Comparable<Point<S>> {

	protected int index;
	protected Instrument instrument;

	protected BasicMarketData preMarketData;

	protected BasePoint(int index, Instrument instrument) {
		if (index < 0)
			throw new IllegalArgumentException("index can not less than 0");
		this.index = index;
		this.instrument = instrument;
	}

	@Override
	public int index() {
		return index;
	}

	@Override
	public Instrument instrument() {
		return instrument;
	}

	@Override
	public int compareTo(Point<S> o) {
		return serial().compareTo(o.serial());
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		handleMarketData(marketData);
		updatePreMarketData(marketData);
	}

	public void updatePreMarketData(BasicMarketData marketData) {
		this.preMarketData = marketData;
	}

	@ProtectedAbstractMethod
	protected abstract void handleMarketData(BasicMarketData marketData);

}
