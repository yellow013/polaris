package io.ffreedom.financial.forex;

import io.ffreedom.financial.AbsInstrument;
import io.ffreedom.financial.InstrumentType;
import io.ffreedom.financial.Symbol;

public abstract class Forex extends AbsInstrument {

	protected Forex(String instrumentId, Symbol symbol) {
		super(instrumentId, symbol);
	}

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.FOREX;
	}

}
