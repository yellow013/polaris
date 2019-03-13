package io.ffreedom.polaris.financial.futures;

public final class ChinaFutures extends Futures {

	private PriorityCloseType priorityCloseType;

	private ChinaFutures(ChinaFuturesSymbol symbol, int term, String instrumentCode,
			PriorityCloseType priorityCloseType) {
		super(symbol.genInstrumentId(term), instrumentCode, symbol);
		this.priorityCloseType = priorityCloseType;
	}

	public static ChinaFutures build(ChinaFuturesSymbol symbol, int term, PriorityCloseType priorityCloseType) {
		return new ChinaFutures(symbol, term, (symbol.name() + "" + term).toLowerCase(), priorityCloseType);
	}

	@Override
	public PriorityCloseType getPriorityCloseType() {
		return priorityCloseType;
	}

}
