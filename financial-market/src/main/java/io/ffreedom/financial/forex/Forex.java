package io.ffreedom.financial.forex;

import io.ffreedom.financial.AbsInstrument;
import io.ffreedom.financial.InstrumentType;
import io.ffreedom.financial.Symbol;

public abstract class Forex extends AbsInstrument {

	

	protected Forex(int instrumentId, Symbol symbol) {
		super(instrumentId, symbol);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.FOREX;
	}

}
