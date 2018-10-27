package io.ffreedom.financial;

public interface Instrument {

	/**
	 * STOCK :  country|exchange|symbol<br>
	 * MAX_VALUE == 21 |47 		|483647<br>
	 * 
	 * FUTURES :country|exchange|symbol|term<br>
	 * MAX_VALUE == 21 |47 		|48    |3647<br>
	 * 
	 * @return int
	 */
	int getInstrumentId();

	InstrumentType getInstrumentType();

	String getInstrumentCode();

	Symbol getSymbol();

}
