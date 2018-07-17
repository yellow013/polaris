package io.ffreedom.financial.futures;

import io.ffreedom.common.utils.StringUtil;

public final class ChinaFutures extends Futures {

	public ChinaFutures(String instrumentCode) {
		// TODO 完善ID生成逻辑
		super(0, ChinaFuturesSymbol.checkOut(analysisSymbol(instrumentCode)));
	}

	public static String analysisSymbol(String instrumentId) {
		if (StringUtil.isNullOrEmpty(instrumentId)) {
			throw new NullPointerException("InstrumentId is null or empty.");
		}
		return instrumentId.replaceAll("\\d", "");
	}

	@Override
	public String getInstrumentCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
