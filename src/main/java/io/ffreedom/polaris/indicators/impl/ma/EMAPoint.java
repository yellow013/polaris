package io.ffreedom.polaris.indicators.impl.ma;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.api.TimePeriodPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class EMAPoint extends TimePeriodPoint<EMAPoint> {

	private double avgPrice;

	public EMAPoint(IndicatorPeriod period, TimePeriod timePeriod) {
		super(period, timePeriod);
	}

	public static EMAPoint with(IndicatorPeriod period, TimePeriod timePeriod) {
		return new EMAPoint(period, timePeriod);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		double lastPrice = marketData.getLastPrice();
	}

	@Override
	protected EMAPoint thisPoint() {
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

}
