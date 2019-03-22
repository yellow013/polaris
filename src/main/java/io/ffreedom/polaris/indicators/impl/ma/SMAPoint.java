package io.ffreedom.polaris.indicators.impl.ma;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.HistoryPriceRecorder;
import io.ffreedom.polaris.indicators.impl.ma.base.MAPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class SMAPoint extends MAPoint<SMAPoint> {

	private double historyPriceSum;

	public SMAPoint(IndicatorPeriod period, TimePeriod timePeriod, HistoryPriceRecorder historyPriceRecorder) {
		super(period, timePeriod, historyPriceRecorder);
		this.historyPriceSum = historyPriceRecorder.sum();
	}

	public static SMAPoint with(IndicatorPeriod period, TimePeriod timePeriod,
			HistoryPriceRecorder historyPriceRecorder) {
		return new SMAPoint(period, timePeriod, historyPriceRecorder);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		this.lastPrice = marketData.getLastPrice();
		historyPriceRecorder.getCount();
		this.avgPrice = historyPriceSum + lastPrice;
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
		return SMAPoint.with(period, timePeriod, historyPriceRecorder.addTail(lastPrice));
	}

}
