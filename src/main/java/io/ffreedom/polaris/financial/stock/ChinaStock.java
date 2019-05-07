package io.ffreedom.polaris.financial.stock;

import io.ffreedom.polaris.financial.Symbol;
import io.ffreedom.polaris.financial.stock.base.Stock;

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
