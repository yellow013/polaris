package io.ffreedom.polaris.indicators.impl.ma;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class SMAPoint extends TimePeriodPoint<SMAPoint> {

	public SMAPoint(IndicatorPeriod period, TimePeriod timePeriod) {
		super(period, timePeriod);
		// TODO Auto-generated constructor stub
	}

	private double avgPrice;

	public static SMAPoint with(IndicatorPeriod period, TimePeriod timePeriod) {
		return new SMAPoint(period, timePeriod);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		double lastPrice = marketData.getLastPrice();
	}

	@Override
	protected SMAPoint thisPoint() {
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
	public SMAPoint generateNext() {
		// TODO Auto-generated method stub
		return null;
	}

}
