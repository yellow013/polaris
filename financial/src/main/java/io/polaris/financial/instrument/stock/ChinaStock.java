package io.polaris.financial.instrument.stock;

import io.polaris.financial.instrument.Symbol;
import io.polaris.financial.instrument.stock.base.Stock;

public final class ChinaStock extends Stock {

	protected ChinaStock(int instrumentId, String instrumentCode, Symbol symbol) {
		super(instrumentId, instrumentCode, symbol);
	}

	@Override
	public boolean isAvailableNow() {
		return false;
	}

	@Override
	public boolean isNakedShort() {
		return false;
	}

}
