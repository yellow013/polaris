package io.ffreedom.financial.forex;

import io.ffreedom.financial.AbsInstrument;
import io.ffreedom.financial.Symbol;

public abstract class Forex extends AbsInstrument {

	protected ExchangeRate rate;

	protected Forex(int instrumentId, String instrumentCode, Symbol symbol) {
		super(instrumentId, instrumentCode, symbol);
	}

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.FOREX;
	}

	@Override
	public boolean isTZero() {
		return true;
	}

}
