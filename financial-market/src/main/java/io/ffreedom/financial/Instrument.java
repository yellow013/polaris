package io.ffreedom.financial;

public interface Instrument {

	InstrumentType getInstrumentType();

	String getInstrumentId();

	Symbol getSymbol();

}
