package io.polaris.indicators.impl.ma;

import io.ffreedom.common.number.DoubleArithmetic;
import io.polaris.datetime.serial.TimePeriodSerial;
import io.polaris.financial.Instrument;
import io.polaris.indicators.api.CalculationCycle;
import io.polaris.indicators.api.IndicatorTimePeriod;
import io.polaris.indicators.impl.ma.base.MaPoint;
import io.polaris.indicators.structure.FixedHistoryPriceRecorder;
import io.polaris.market.impl.BasicMarketData;

public final class SmaPoint extends MaPoint<SmaPoint> {

	private double historyPriceSum;

	private CalculationCycle cycle;

	public SmaPoint(int index, Instrument instrument, IndicatorTimePeriod period, TimePeriodSerial timePeriod,
			CalculationCycle cycle, FixedHistoryPriceRecorder historyPriceRecorder) {
		super(index, instrument, period, timePeriod, historyPriceRecorder);
		this.historyPriceSum = historyPriceRecorder.sum();
		this.cycle = cycle;
	}

	public static SmaPoint with(int indxe, Instrument instrument, IndicatorTimePeriod period, TimePeriodSerial timePeriod,
			CalculationCycle cycle, FixedHistoryPriceRecorder historyPriceRecorder) {
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
		this.avgPrice = DoubleArithmetic.correction4(historyPriceSum + lastPrice / count);
	}

}
