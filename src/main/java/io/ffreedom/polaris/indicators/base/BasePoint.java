package io.ffreedom.polaris.indicators.base;

import io.ffreedom.common.sequence.Serial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.Point;
import io.ffreedom.polaris.market.impl.BasicMarketData;

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
	public int getIndex() {
		return index;
	}

	@Override
	public Instrument getInstrument() {
		return instrument;
	}

	@Override
	public int compareTo(Point<S> o) {
		return getSerial().compareTo(o.getSerial());
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		handleMarketData(marketData);
		this.preMarketData = marketData;
	}

	protected abstract void handleMarketData(BasicMarketData marketData);

}
