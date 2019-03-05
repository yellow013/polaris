package io.ffreedom.polaris.financial;

public abstract class AbstractInstrument implements Instrument {

	private int instrumentId;
	private String instrumentCode;
	private Symbol symbol;
	private boolean isEnable;

	protected AbstractInstrument(int instrumentId, String instrumentCode, Symbol symbol) {
		this.instrumentId = instrumentId;
		this.instrumentCode = instrumentCode;
		this.symbol = symbol;
	}

	@Override
	public void disable() {
		this.isEnable = false;
	}

	@Override
	public void enable() {
		this.isEnable = true;
	}

	@Override
	public boolean isDisabled() {
		return !isEnable;
	}

	@Override
	public boolean isEnabled() {
		return isEnable;
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
