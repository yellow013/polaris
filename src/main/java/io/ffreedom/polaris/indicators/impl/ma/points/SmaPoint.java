package io.ffreedom.polaris.indicators.impl.ma.points;

import io.ffreedom.common.number.DoubleUtil;
import io.ffreedom.polaris.datetime.XTimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.structure.FixedLengthHistoryPriceRecorder;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public class SmaPoint extends MaPoint<SmaPoint> {

	private double historyPriceSum;

	private CalculationCycle cycle;

	public SmaPoint(int index, Instrument instrument, IndicatorTimePeriod period, XTimePeriod timePeriod,
			CalculationCycle cycle, FixedLengthHistoryPriceRecorder historyPriceRecorder) {
		super(index, instrument, period, timePeriod, historyPriceRecorder);
		this.historyPriceSum = historyPriceRecorder.sum();
		this.cycle = cycle;
	}

	public static SmaPoint with(int indxe, Instrument instrument, IndicatorTimePeriod period, XTimePeriod timePeriod,
			CalculationCycle cycle, FixedLengthHistoryPriceRecorder historyPriceRecorder) {
		return new SmaPoint(indxe, instrument, period, timePeriod, cycle, historyPriceRecorder);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {

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

	public CalculationCycle getCycle() {
		return cycle;
	}

	@Override
	public SmaPoint generateNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		this.lastPrice = marketData.getLastPrice();
		int count = historyPriceRecorder.getCount();
		this.avgPrice = DoubleUtil.correction4(historyPriceSum + lastPrice / count);

	}

}
