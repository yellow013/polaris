package io.ffreedom.polaris.indicators.impl.macd.point;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class MacdPoint extends TimePeriodPoint<MacdPoint> {

	private MacdPoint(int index, Instrument instrument, IndicatorPeriod period, TimePeriod timePeriod) {
		super(index, instrument, period, timePeriod);
	}

	@SuppressWarnings("unused")
	private double avgPrice;

	@Override
	public void onMarketData(BasicMarketData marketData) {
		double lastPrice = marketData.getLastPrice();
	}

	@Override
	protected MacdPoint thisPoint() {
		return this;
	}

	public static void main(String[] args) {

		double d = 1 + 1 + 6 + 10;
		double b = d / 4;
		System.out.println(b);
		double b1 = b + 20;
		System.out.println(b1 / 2);
		System.out.println((1 + 1 + 6 + 10 + 20) / 2);

	}

	@Override
	public MacdPoint generateNext() {
		return null;
	}

}
