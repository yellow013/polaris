package io.ffreedom.financial.forex.cryptocurrency;

import io.ffreedom.financial.Symbol;
import io.ffreedom.financial.forex.Forex;

public final class Cryptocurrency extends Forex {

	protected Cryptocurrency(int instrumentId, Symbol symbol) {
		super(instrumentId, symbol.getSymbolCode(), symbol);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getInstrumentCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
