package io.ffreedom.financial.forex.cryptocurrency;

import io.ffreedom.financial.Symbol;
import io.ffreedom.financial.forex.Forex;

public final class CryptocurrencyExchange extends Forex {

	protected CryptocurrencyExchange(String instrumentId, Symbol symbol) {
		super(instrumentId, symbol);
	}

}
