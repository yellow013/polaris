package io.ffreedom.financial.futures;

import io.ffreedom.common.utils.StringUtil;

public final class ChinaFutures extends Futures {

	public ChinaFutures(String instrumentId) {
		super(instrumentId, ChinaFuturesSymbol.checkOut(analysisSymbol(instrumentId)));

	}

	public static String analysisSymbol(String futureInstrumentId) {
		if (StringUtil.isNullOrEmpty(futureInstrumentId)) {
			return futureInstrumentId;
		}
		return futureInstrumentId.replaceAll("\\d", "");
	}

}
