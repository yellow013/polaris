package io.ffreedom.financial;

public enum Exchanges implements Exchange{
	
	//Shanghai Futures Exchange
	SHFE,
	
	//Zhengzhou Commodity Exchange
	ZCE,
	
	//Dalian Commodity Exchange
	DCE,
	
	//China Financial Futures Exchange
	CFFE,
	
	//Shanghai International Energy Exchange
	SIEE
	
	;

	@Override
	public String getExchangeCode() {
		return this.name();
	}

}
