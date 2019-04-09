package io.ffreedom.polaris.indicators.impl.ma;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import io.ffreedom.polaris.datetime.TimePeriod;
import io.ffreedom.polaris.datetime.TradingPeriod;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;
import io.ffreedom.polaris.indicators.api.IndicatorPeriod;
import io.ffreedom.polaris.indicators.events.SmaEvent;
import io.ffreedom.polaris.indicators.impl.AbstractUnpooledIndicator;
import io.ffreedom.polaris.indicators.impl.FixedLengthHistoryPriceRecorder;
import io.ffreedom.polaris.indicators.impl.ma.point.SmaPoint;
import io.ffreedom.polaris.indicators.pools.TradingPeriodPool;
import io.ffreedom.polaris.market.BasicMarketData;

public final class UnpooledSma extends AbstractUnpooledIndicator<SmaPoint, SmaEvent> {

	private FixedLengthHistoryPriceRecorder historyPriceRecorder;

	public UnpooledSma(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		super(instrument, period, cycle);
	}

	public static UnpooledSma with(Instrument instrument, IndicatorPeriod period, IndicatorCycle cycle) {
		return new UnpooledSma(instrument, period, cycle);
	}

	@Override
	protected SmaPoint initFirstPoint() {
		this.historyPriceRecorder = FixedLengthHistoryPriceRecorder.newRecorder(cycle);
		TradingPeriod tradingPeriod = TradingPeriodPool.Singleton.getAfterTradingPeriod(instrument, LocalTime.now());
		LocalDate nowDate = LocalDate.now();
		TimePeriod timePeriod = TimePeriod.with(LocalDateTime.of(nowDate, tradingPeriod.getStartTime()),
				LocalDateTime.of(nowDate, tradingPeriod.getStartTime().plusSeconds(period.getSeconds()).minusNanos(1)));
		return SmaPoint.with(0, instrument, period, timePeriod, cycle, historyPriceRecorder);
	}

	@Override
	protected SmaPoint generateNextPoint(SmaPoint currentPoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isCurrentPointPeriod(BasicMarketData marketData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		// TODO Auto-generated method stub

	}

}
