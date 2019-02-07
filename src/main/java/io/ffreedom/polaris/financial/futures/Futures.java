package io.ffreedom.polaris.financial.futures;

import io.ffreedom.polaris.financial.AbsInstrument;
import io.ffreedom.polaris.financial.Symbol;

public abstract class Futures extends AbsInstrument {

	public Futures(int instrumentId, String instrumentCode, Symbol symbol) {
		super(instrumentId, instrumentCode, symbol);
	}

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.FUTURES;
	}
	
	@Override
	public boolean isTZero() {
		return true;
	}

}
