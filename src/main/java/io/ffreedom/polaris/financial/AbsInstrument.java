package io.ffreedom.polaris.financial;

public abstract class AbsInstrument implements Instrument {

	private int instrumentId;
	private String instrumentCode;
	private Symbol symbol;

	protected AbsInstrument(int instrumentId, String instrumentCode, Symbol symbol) {
		this.instrumentId = instrumentId;
		this.instrumentCode = instrumentCode;
		this.symbol = symbol;
	}

	@Override
	public int getInstrumentId() {
		return instrumentId;
	}

	@Override
	public String getInstrumentCode() {
		return instrumentCode;
	}

	@Override
	public Symbol getSymbol() {
		return symbol;
	}

}
