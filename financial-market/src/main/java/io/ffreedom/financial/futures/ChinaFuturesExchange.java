package io.ffreedom.financial.futures;

import io.ffreedom.financial.Exchange;

public enum ChinaFuturesExchange implements Exchange {

	// Shanghai Futures Exchange
	SHFE(1),

	// Zhengzhou Commodity Exchange
	ZCE(2),

	// Dalian Commodity Exchange
	DCE(3),

	// China Financial Futures Exchange
	CFFE(4),

	// Shanghai International Energy Exchange
	SIEE(5)

	;

	private int exchangeId;

	private ChinaFuturesExchange(int exchangeId) {
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
