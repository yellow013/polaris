package io.ffreedom.financial.futures;

import io.ffreedom.common.utils.StringUtil;

public final class ChinaFutures extends Futures {

	public ChinaFutures(String instrumentId) {
		super(instrumentId, ChinaFuturesSymbol.checkOut(analysisSymbol(instrumentId)));
	}

	public static String analysisSymbol(String instrumentId) {
		if (StringUtil.isNullOrEmpty(instrumentId)) {
			throw new NullPointerException("InstrumentId is null or empty.");
		}
		return instrumentId.replaceAll("\\d", "");
	}

}
