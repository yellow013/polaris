package io.ffreedom.polaris.financial;

import io.ffreedom.common.fsm.Enable;

public interface Instrument extends Enable{

	/**
	 * STOCK : country|exchange|symbol<br>
	 * MAX_VALUE == 21 |47 |483647<br>
	 * 
	 * FUTURES :country|exchange|symbol|term<br>
	 * MAX_VALUE == 21 |47 |48 |3647<br>
	 * 
	 * @return int
	 */
	int getInstrumentId();

	InstrumentType getInstrumentType();

	String getInstrumentCode();

	Symbol getSymbol();

	boolean isTZero();

	default PriorityCloseType getPriorityCloseType() {
		return PriorityCloseType.NONE;
	}

	public static enum InstrumentType {

		BOND(false),

		OPTION(true),

		STOCK(false),

		FUTURES(true),

		FOREX(true),

		FUND(false),

		INVALID(false)

		;

		private boolean isNakedShort;

		private InstrumentType(boolean isNakedShort) {
			this.isNakedShort = isNakedShort;
		}

		public boolean isNakedShort() {
			return isNakedShort;
		}
	}

	public static enum PriorityCloseType {
		NONE, BEFORE_TODAY
	}

}
