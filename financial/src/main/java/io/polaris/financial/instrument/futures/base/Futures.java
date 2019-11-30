package io.polaris.financial.instrument.futures.base;

import io.polaris.financial.instrument.AbstractInstrument;
import io.polaris.financial.instrument.Symbol;

public abstract class Futures extends AbstractInstrument {

	public Futures(int instrumentId, String instrumentCode, Symbol symbol) {
		super(instrumentId, instrumentCode, symbol);
	}

	@Override
	public InstrumentType instrumentType() {
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
