package io.ffreedom.financial;

public abstract class AbsInstrument implements Instrument {

	private int instrumentId;
	private Symbol symbol;
	
	protected AbsInstrument(int instrumentId, Symbol symbol) {
		this.instrumentId = instrumentId;
		this.symbol = symbol;
	}

	@Override
	public int getInstrumentId() {
		return instrumentId;
	}

	@Override
	public Symbol getSymbol() {
		return symbol;
	}

}
