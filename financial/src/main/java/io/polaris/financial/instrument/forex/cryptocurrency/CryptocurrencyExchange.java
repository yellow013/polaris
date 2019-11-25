package io.polaris.financial.instrument.forex.cryptocurrency;

import io.polaris.financial.instrument.Symbol;
import io.polaris.financial.instrument.forex.base.Forex;

public final class CryptocurrencyExchange extends Forex {

	protected CryptocurrencyExchange(int instrumentId, Symbol symbol) {
		super(instrumentId, symbol.getSymbolName(), symbol);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getInstrumentCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
