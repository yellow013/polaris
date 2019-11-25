package io.polaris.financial.instrument.stock.base;

import io.polaris.financial.instrument.AbstractInstrument;
import io.polaris.financial.instrument.Symbol;

public abstract class Stock extends AbstractInstrument {

	protected Stock(int instrumentId, String instrumentCode, Symbol symbol) {
		super(instrumentId, instrumentCode, symbol);
	}

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.STOCK;
	}

}
