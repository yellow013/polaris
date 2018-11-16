package io.ffreedom.financial.futures;

public final class ChinaFutures extends Futures {

	PriorityCloseType priorityCloseType;

	public ChinaFutures(int term, String instrumentCode, ChinaFuturesSymbol symbol,
			PriorityCloseType priorityCloseType) {
		super(symbol.generateInstrumentId(term), instrumentCode, symbol);
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
