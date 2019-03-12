package io.ffreedom.polaris.financial.futures;

public final class ChinaFutures extends Futures {

	PriorityCloseType priorityCloseType;

	public ChinaFutures(int term, String instrumentCode, ChinaFuturesSymbol symbol,
			PriorityCloseType priorityCloseType) {
		super(symbol.genInstrumentId(term), instrumentCode, symbol);
		this.priorityCloseType = priorityCloseType;
	}

	@Override
	public boolean isTZero() {
		return false;
	}

	@Override
	public PriorityCloseType getPriorityCloseType() {
		return priorityCloseType;
	}

}
