package io.ffreedom.polaris.financial.forex.cryptocurrency;

import io.ffreedom.polaris.financial.Symbol;
import io.ffreedom.polaris.financial.forex.base.Forex;

public final class Cryptocurrency extends Forex {

	protected Cryptocurrency(int instrumentId, Symbol symbol) {
		super(instrumentId, symbol.getSymbolName(), symbol);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getInstrumentCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
