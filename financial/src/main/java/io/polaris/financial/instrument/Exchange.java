package io.polaris.financial.instrument;

import java.time.ZoneId;

import io.ffreedom.common.datetime.TimeZones;

public enum Exchange {

	// Shanghai Futures Exchange
	SHFE(41, TimeZones.CST),

	// Zhengzhou Commodity Exchange
	ZCE(42, TimeZones.CST),

	// Dalian Commodity Exchange
	DCE(43, TimeZones.CST),

	// China Financial Futures Exchange
	CFFE(44, TimeZones.CST),

	// Shanghai International Energy Exchange
	SIEE(45, TimeZones.CST),

	// Tokyo Commodity Exchange
	TOCOM(11, TimeZones.JST),

	;

	private int exchangeId;

	private ZoneId zoneId;

	private Exchange(int exchangeId, ZoneId zoneId) {
		this.exchangeId = exchangeId * 10000000;
		this.zoneId = zoneId;

	}

	public String getExchangeCode() {
		return this.name();
	}

	public int getExchangeId() {
		return exchangeId;
	}

	public ZoneId getZoneId() {
		return zoneId;
	}

}