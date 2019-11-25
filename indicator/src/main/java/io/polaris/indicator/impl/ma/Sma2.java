package io.polaris.indicators.impl.ma;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import io.polaris.datetime.TradingPeriod;
import io.polaris.datetime.TradingPeriodPool;
import io.polaris.datetime.serial.TimePeriodSerial;
import io.polaris.financial.Instrument;
import io.polaris.indicators.api.CalculationCycle;
import io.polaris.indicators.api.IndicatorTimePeriod;
import io.polaris.indicators.base.BaseTimePeriodIndicator;
import io.polaris.indicators.events.SmaEvent;
import io.polaris.indicators.structure.FixedHistoryPriceRecorder;
import io.polaris.market.impl.BasicMarketData;

public final class Sma2 extends BaseTimePeriodIndicator<SmaPoint, SmaEvent> {

	private FixedHistoryPriceRecorder historyPriceRecorder;

	public Sma2(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		super(instrument, period, cycle);
		this.historyPriceRecorder = FixedHistoryPriceRecorder.newRecorder(cycle);
		TradingPeriod tradingPeriod = TradingPeriodPool.Singleton.getAfterTradingPeriod(instrument, LocalTime.now());
		LocalDate nowDate = LocalDate.now();
		TimePeriodSerial timePeriod = TimePeriodSerial.with(LocalDateTime.of(nowDate, tradingPeriod.getStartTime()),
				LocalDateTime.of(nowDate, tradingPeriod.getStartTime().plusSeconds(period.getSeconds()).minusNanos(1)));
		currentPoint = SmaPoint.with(0, instrument, period, timePeriod, cycle, historyPriceRecorder);
	}

	public static Sma2 with(Instrument instrument, IndicatorTimePeriod period, CalculationCycle cycle) {
		return new Sma2(instrument, period, cycle);
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
