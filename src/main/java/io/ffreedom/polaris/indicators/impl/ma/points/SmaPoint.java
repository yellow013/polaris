package io.ffreedom.polaris.indicators.impl.ma.point;

import io.ffreedom.common.utils.DoubleUtil;
import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.impl.FixedLengthHistoryPriceRecorder;
import io.ffreedom.polaris.indicators.impl.ma.base.MAPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class SmaPoint extends MAPoint<SmaPoint> {

	private double historyPriceSum;

	private IndicatorCycle cycle;

	public SmaPoint(int index, Instrument instrument, IndicatorPeriod period, TimePeriod timePeriod,
			IndicatorCycle cycle, FixedLengthHistoryPriceRecorder historyPriceRecorder) {
		super(index, instrument, period, timePeriod, historyPriceRecorder);
		this.historyPriceSum = historyPriceRecorder.sum();
		this.cycle = cycle;
	}

	public static SmaPoint with(int indxe, Instrument instrument, IndicatorPeriod period, TimePeriod timePeriod,
			IndicatorCycle cycle, FixedLengthHistoryPriceRecorder historyPriceRecorder) {
		return new SmaPoint(indxe, instrument, period, timePeriod, cycle, historyPriceRecorder);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		this.lastPrice = marketData.getLastPrice();
		int count = historyPriceRecorder.getCount();
		this.avgPrice = DoubleUtil.correction4(historyPriceSum + lastPrice / count);
	}

	@Override
	protected SmaPoint thisObj() {
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

	public IndicatorCycle getCycle() {
		return cycle;
	}

	@Override
	public SmaPoint generateNext() {
		// TODO Auto-generated method stub
		return null;
	}

}
