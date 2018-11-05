package io.ffreedom.financial.futures;

import io.ffreedom.financial.AbsInstrument;
import io.ffreedom.financial.InstrumentType;
import io.ffreedom.financial.Symbol;

public abstract class Futures extends AbsInstrument {

	public Futures(int instrumentId, String instrumentCode, Symbol symbol) {
		super(instrumentId, instrumentCode, symbol);
	}

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.FUTURES;
	}

}
