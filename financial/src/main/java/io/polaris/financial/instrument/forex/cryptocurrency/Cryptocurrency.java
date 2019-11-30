package io.polaris.financial.instrument.forex.cryptocurrency;

import io.polaris.financial.instrument.Symbol;
import io.polaris.financial.instrument.forex.base.Forex;

public final class Cryptocurrency extends Forex {

	protected Cryptocurrency(int instrumentId, Symbol symbol) {
		super(instrumentId, symbol.getSymbolName(), symbol);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String instrumentCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
