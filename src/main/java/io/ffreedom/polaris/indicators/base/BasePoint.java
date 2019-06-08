package io.ffreedom.polaris.indicators.base;

import io.ffreedom.common.sequence.Serial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.Point;
import io.ffreedom.polaris.market.impl.BasicMarketData;

abstract class BasePoint<X extends Serial<X>, Y extends Point<X, Y>> implements Point<X, Y>, Comparable<Y> {

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
	public Y getYAxis() {
		return thisObj();
	}

	@Override
	public int compareTo(Y o) {
		return getXAxis().compareTo(o.getXAxis());
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		handleMarketData(marketData);
		this.preMarketData = marketData;
	}

	protected abstract void handleMarketData(BasicMarketData marketData);

	protected abstract Y thisObj();

}
