package io.ffreedom.polaris.financial.forex.cryptocurrency;

import io.ffreedom.polaris.financial.Symbol;
import io.ffreedom.polaris.financial.forex.Forex;

public final class CryptocurrencyExchange extends Forex {

	protected CryptocurrencyExchange(int instrumentId, Symbol symbol) {
		super(instrumentId, symbol.getSymbolCode(), symbol);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getInstrumentCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
