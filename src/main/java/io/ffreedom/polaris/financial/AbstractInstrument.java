package io.ffreedom.polaris.financial;

public abstract class AbstractInstrument implements Instrument {

	private int instrumentId;
	private String instrumentCode;
	private Symbol symbol;
	private boolean isEnable = false;

	protected AbstractInstrument(int instrumentId, String instrumentCode, Symbol symbol) {
		this.instrumentId = instrumentId;
		this.instrumentCode = instrumentCode;
		this.symbol = symbol;
	}

	@Override
	public boolean enabled() {
		return isEnable;
	}

	@Override
	public void setEnable(boolean enable) {
		if (enable)
			this.isEnable = true;
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
