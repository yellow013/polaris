package io.ffreedom.polaris.market;

public interface MarketData {

	MarketDataType getMarketDataType();

	public static enum MarketDataType {
		Basic, Depth, Group
	}

}
