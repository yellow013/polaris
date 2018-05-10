package io.ffreedom.financial.future;

import io.ffreedom.common.utils.StringUtil;
import io.ffreedom.financial.Instrument;
import io.ffreedom.financial.InstrumentType;
import io.ffreedom.financial.Symbol;

public final class Future implements Instrument {

	private String instrumentId;

	private Symbol symbol;

	public Future(String instrumentId) {
		super();
		this.instrumentId = instrumentId;
		this.symbol = FutureSymbol.checkOut(analysisSymbol(instrumentId));
	}

	@Override
	public String getInstrumentId() {
		return instrumentId;
	}

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.FUTURE;
	}

	public static String analysisSymbol(String futureInstrumentId) {
		if (StringUtil.isNullOrEmpty(futureInstrumentId)) {
			return futureInstrumentId;
		}
		return futureInstrumentId.replaceAll("\\d", "");
	}

	@Override
	public Symbol getSymbol() {
		return symbol;
	}

}
