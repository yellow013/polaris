package io.ffreedom.polaris.financial.stock;

import io.ffreedom.polaris.financial.AbstractInstrument;
import io.ffreedom.polaris.financial.Symbol;

public final class Stock extends AbstractInstrument {

	protected Stock(int instrumentId, String instrumentCode, Symbol symbol) {
		super(instrumentId, instrumentCode, symbol);
		// TODO Auto-generated constructor stub
	}

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
