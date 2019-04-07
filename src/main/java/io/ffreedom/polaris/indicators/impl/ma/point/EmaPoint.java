package io.ffreedom.polaris.indicators.impl.ma.point;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class EmaPoint extends TimePeriodPoint<EmaPoint> {

	private double avgPrice;

	private EmaPoint(int index, IndicatorPeriod period, TimePeriod timePeriod) {
		super(index, period, timePeriod);
	}

	public static EmaPoint with(int index, IndicatorPeriod period, TimePeriod timePeriod) {
		return new EmaPoint(index, period, timePeriod);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		double lastPrice = marketData.getLastPrice();
	}

	@Override
	protected EmaPoint thisPoint() {
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
	public EmaPoint generateNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

}
