package io.ffreedom.financial.futures;

import io.ffreedom.financial.AbsInstrument;
import io.ffreedom.financial.InstrumentType;
import io.ffreedom.financial.Symbol;

public abstract class Futures extends AbsInstrument {

	public Futures(String instrumentId, Symbol symbol) {
		super(instrumentId, symbol);
	}

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.FUTURES;
	}

}
