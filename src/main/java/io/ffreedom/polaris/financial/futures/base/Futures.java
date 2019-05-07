package io.ffreedom.polaris.financial.futures.base;

import io.ffreedom.polaris.financial.AbstractInstrument;
import io.ffreedom.polaris.financial.Symbol;

public abstract class Futures extends AbstractInstrument {

	public Futures(int instrumentId, String instrumentCode, Symbol symbol) {
		super(instrumentId, instrumentCode, symbol);
	}

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.FUTURES;
	}

	@Override
	public boolean isAvailableNow() {
		return true;
	}

	@Override
	public boolean isNakedShort() {
		return true;
	}
}
