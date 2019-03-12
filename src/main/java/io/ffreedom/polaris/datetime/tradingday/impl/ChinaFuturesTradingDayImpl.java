package io.ffreedom.polaris.datetime.tradingday.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.concurrent.ThreadSafe;

import io.ffreedom.polaris.datetime.tradingday.api.TradingDay;
import io.ffreedom.polaris.financial.futures.ChinaFuturesUtil;

/**
 * 在收盘后至15点05分之前启动获得的TradinDay将存在误差
 * 
 * @author yellow013
 *
 */
@ThreadSafe
public final class ChinaFuturesTradingDayImpl implements TradingDay {

	public final static TradingDay INSTANCE = new ChinaFuturesTradingDayImpl();

	private AtomicReference<LocalDate> current = new AtomicReference<>(
			ChinaFuturesUtil.analysisTradingDay(LocalDateTime.now()));

	private ChinaFuturesTradingDayImpl() {

	}

	@Override
	public LocalDate current() {
		return current.get();
	}

	@Override
	public TradingDay set(LocalDate date) {
		current.set(date);
		return this;
	}

	public static void main(String[] args) {

		TradingDay tradingDay = ChinaFuturesTradingDayImpl.INSTANCE;
		tradingDay.set(ChinaFuturesUtil
				.analysisTradingDay(LocalDateTime.of(LocalDate.of(2019, 3, 15), LocalTime.of(15, 20, 40))));

		System.out.println(tradingDay.current());

	}

}
