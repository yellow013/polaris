package io.ffreedom.indicators.utils;

import com.google.common.collect.Table;

import io.ffreedom.financial.Symbol;
import io.ffreedom.indicators.api.IndicatorPeriod;
import io.ffreedom.market.data.TimeTwin;

//TODO 池化时间分割机制
public final class IndicatorPeriodTimePools {

	private boolean isInit;

	private Table<IndicatorPeriod, Symbol, TimeTwin> table;

}
