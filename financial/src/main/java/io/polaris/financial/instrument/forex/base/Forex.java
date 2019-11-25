package io.polaris.financial.forex.base;

import io.polaris.financial.AbstractInstrument;
import io.polaris.financial.Symbol;

public abstract class Forex extends AbstractInstrument {

	private long multiplier;

	protected Forex(int instrumentId, String instrumentCode, Symbol symbol) {
		super(instrumentId, instrumentCode, symbol);
	}

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.FOREX;
	}

	@Override
	public boolean isAvailableNow() {
		return true;
	}

	@Override
	public boolean isNakedShort() {
		return true;
	}

	public long getMultiplier() {
		return multiplier;
	}

}
