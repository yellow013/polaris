package io.ffreedom.financial;

public abstract class AbsInstrument implements Instrument {

	private String instrumentId;
	private Symbol symbol;
	
	protected AbsInstrument(String instrumentId, Symbol symbol) {
		this.instrumentId = instrumentId;
		this.symbol = symbol;
	}

	@Override
	public String getInstrumentId() {
		return instrumentId;
	}

	@Override
	public Symbol getSymbol() {
		return symbol;
	}

}
