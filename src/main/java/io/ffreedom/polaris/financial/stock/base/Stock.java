package io.ffreedom.polaris.financial.stock.base;

import io.ffreedom.polaris.financial.AbstractInstrument;
import io.ffreedom.polaris.financial.Symbol;

public abstract class Stock extends AbstractInstrument {

	protected Stock(int instrumentId, String instrumentCode, Symbol symbol) {
		super(instrumentId, instrumentCode, symbol);
	}

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.STOCK;
	}

}
