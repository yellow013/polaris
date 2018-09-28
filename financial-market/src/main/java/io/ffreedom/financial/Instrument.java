package io.ffreedom.financial;

public interface Instrument {

	int getInstrumentId();

	InstrumentType getInstrumentType();
	
	String getInstrumentCode();

	Symbol getSymbol();

}
