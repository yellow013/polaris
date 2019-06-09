package io.ffreedom.polaris.indicators.impl.ma;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import io.ffreedom.polaris.datetime.TradingPeriod;
import io.ffreedom.polaris.datetime.TradingPeriodPool;
import io.ffreedom.polaris.datetime.XTimePeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.CalculationCycle;
import io.ffreedom.polaris.indicators.api.IndicatorTimePeriod;
import io.ffreedom.polaris.indicators.base.BaseTimePeriodIndicator;
import io.ffreedom.polaris.indicators.events.SmaEvent;
import io.ffreedom.polaris.indicators.structure.FixedLengthHistoryPriceRecorder;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public final class Sma2 extends BaseTimePeriodIndicator<SmaPoint, SmaEvent> {

	private FixedLengthHistoryPriceRecorder historyPriceRecorder;

	public Sma2(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		super(instrument, period, cycle);
	}

	public static Sma2 with(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		return new Sma2(instrument, period, cycle);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub
	}

	@Override
	protected SmaPoint initialize() {
		this.historyPriceRecorder = FixedLengthHistoryPriceRecorder.newRecorder(cycle);
		TradingPeriod tradingPeriod = TradingPeriodPool.Singleton.getAfterTradingPeriod(instrument, LocalTime.now());
		LocalDate nowDate = LocalDate.now();
		XTimePeriod timePeriod = XTimePeriod.with(LocalDateTime.of(nowDate, tradingPeriod.getStartTime()),
				LocalDateTime.of(nowDate, tradingPeriod.getStartTime().plusSeconds(period.getSeconds()).minusNanos(1)));
		return SmaPoint.with(0, instrument, period, timePeriod, cycle, historyPriceRecorder);
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
