package io.ffreedom.financial;

public interface Instrument {

	InstrumentType getInstrumentType();

	int getInstrumentId();
	
	String getInstrumentCode();

	Symbol getSymbol();

}
