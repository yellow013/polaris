package io.ffreedom.financial.stock;

import io.ffreedom.financial.Instrument;
import io.ffreedom.financial.Symbol;

public final class Stock implements Instrument {

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.STOCK;
	}

	@Override
	public int getInstrumentId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getInstrumentCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol getSymbol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTZero() {
		// TODO Auto-generated method stub
		return false;
	}

}
