package io.polaris.indicator.impl.ma;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import io.polaris.financial.instrument.Instrument;
import io.polaris.financial.market.impl.BasicMarketData;
import io.polaris.financial.time.TradingPeriod;
import io.polaris.financial.time.TradingPeriodPool;
import io.polaris.indicator.api.CalculationCycle;
import io.polaris.indicator.base.BaseTimePeriodIndicator;
import io.polaris.indicator.events.SmaEvent;
import io.polaris.indicator.structure.FixedHistoryPriceRecorder;
import io.polaris.vector.TimePeriod;
import io.polaris.vector.TimePeriodSerial;

public final class Sma2 extends BaseTimePeriodIndicator<SmaPoint, SmaEvent> {

	private FixedHistoryPriceRecorder historyPriceRecorder;

	public Sma2(Instrument instrument, TimePeriod period, CalculationCycle cycle) {
		super(instrument, period, cycle);
		this.historyPriceRecorder = FixedHistoryPriceRecorder.newRecorder(cycle);
		TradingPeriod tradingPeriod = TradingPeriodPool.Singleton.getAfterTradingPeriod(instrument, LocalTime.now());
		LocalDate nowDate = LocalDate.now();
		TimePeriodSerial timePeriod = TimePeriodSerial.with(LocalDateTime.of(nowDate, tradingPeriod.getStartTime()),
				LocalDateTime.of(nowDate, tradingPeriod.getStartTime().plusSeconds(period.getSeconds()).minusNanos(1)));
		currentPoint = SmaPoint.with(0, instrument, period, timePeriod, cycle, historyPriceRecorder);
	}

	public static Sma2 with(Instrument instrument, TimePeriod period, CalculationCycle cycle) {
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
