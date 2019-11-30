package io.polaris.financial.instrument;

import io.mercury.common.fsm.Enable;

public interface Instrument extends Enable {

	/**
	 * STOCK : exchange|symbol<br>
	 * MAX_VALUE == 214|7483647<br>
	 * 
	 * FUTURES:exchange|symbol|term<br>
	 * MAX_VALUE == 214| 74 |83647<br>
	 * 
	 * @return int
	 */
	int instrumentId();

	InstrumentType instrumentType();

	String instrumentCode();

	Symbol symbol();

	boolean isAvailableNow();

	boolean isNakedShort();

	default PriorityCloseType getPriorityCloseType() {
		return PriorityCloseType.NONE;
	}

	public static enum InstrumentType {

		BOND,

		OPTION,

		STOCK,

		FUTURES,

		FOREX,

		FUND,

		;

	}

	public static enum PriorityCloseType {
		NONE, BEFORE_TODAY
	}

}
