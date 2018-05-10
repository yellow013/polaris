package io.ffreedom.financial.future;

import io.ffreedom.common.utils.StringUtil;

public final class FutureUtil {

	public static String analysisSymbol(String instrumentId) {
		if (StringUtil.isNullOrEmpty(instrumentId)) {
			return instrumentId;
		}
		return instrumentId.replaceAll("\\d", "");
	}

}
