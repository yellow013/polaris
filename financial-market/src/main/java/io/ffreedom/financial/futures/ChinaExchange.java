package io.ffreedom.financial.futures;

import io.ffreedom.financial.Exchange;

public enum ChinaExchange implements Exchange {

	// Shanghai Futures Exchange
	SHFE(11),

	// Zhengzhou Commodity Exchange
	ZCE(12),

	// Dalian Commodity Exchange
	DCE(13),

	// China Financial Futures Exchange
	CFFE(14),

	// Shanghai International Energy Exchange
	SIEE(15)

	;

	private int exchangeId;

	private ChinaExchange(int exchangeId) {
		this.exchangeId = exchangeId;
	}

	@Override
	public String getExchangeCode() {
		return this.name();
	}

	@Override
	public int getExchangeId() {
		return exchangeId;
	}

}
