package io.ffreedom.polaris.indicators.impl.ma;

import io.ffreedom.common.number.DoubleUtil;
import io.ffreedom.polaris.datetime.serial.TimePeriodSerial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.impl.ma.base.MaPoint;
import io.ffreedom.polaris.indicators.structure.FixedLengthHistoryPriceRecorder;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public final class SmaPoint extends MaPoint<SmaPoint> {

	private double historyPriceSum;

	private CalculationCycle cycle;

	public SmaPoint(int index, Instrument instrument, IndicatorTimePeriod period, TimePeriodSerial timePeriod,
			CalculationCycle cycle, FixedLengthHistoryPriceRecorder historyPriceRecorder) {
		super(index, instrument, period, timePeriod, historyPriceRecorder);
		this.historyPriceSum = historyPriceRecorder.sum();
		this.cycle = cycle;
	}

	public static SmaPoint with(int indxe, Instrument instrument, IndicatorTimePeriod period, TimePeriodSerial timePeriod,
			CalculationCycle cycle, FixedLengthHistoryPriceRecorder historyPriceRecorder) {
		return new SmaPoint(indxe, instrument, period, timePeriod, cycle, historyPriceRecorder);
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
	protected void handleMarketData(BasicMarketData marketData) {
		this.lastPrice = marketData.getLastPrice();
		int count = historyPriceRecorder.getCount();
		this.avgPrice = DoubleUtil.correction4(historyPriceSum + lastPrice / count);
	}

}
