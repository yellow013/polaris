package io.ffreedom.financial;

public enum Exchange {

	// Shanghai Futures Exchange
	SHFE(41, Country.CHINA),

	// Zhengzhou Commodity Exchange
	ZCE(42, Country.CHINA),

	// Dalian Commodity Exchange
	DCE(43, Country.CHINA),

	// China Financial Futures Exchange
	CFFE(44, Country.CHINA),

	// Shanghai International Energy Exchange
	SIEE(45, Country.CHINA),

	// Tokyo Commodity Exchange
	TOCOM(11, Country.JAPAN),

	;

	private int exchangeId;
	private Country country;

	private Exchange(int exchangeId, Country country) {
		this.exchangeId = country.getCountryId() + exchangeId * 1000000;
		this.country = country;
	}

	public String getExchangeCode() {
		return this.name();
	}

	public int getExchangeId() {
		return exchangeId;
	}

	public Country getCountry() {
		return country;
	}

}
