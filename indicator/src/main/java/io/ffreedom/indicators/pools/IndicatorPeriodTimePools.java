package io.ffreedom.indicators.pools;

import com.google.common.collect.Table;

import io.ffreedom.financial.Instrument;
import io.ffreedom.indicators.api.IndicatorPeriod;
import io.ffreedom.market.TimeTwin;

//TODO 池化时间分割机制
public final class IndicatorPeriodTimePools {

	private boolean isInit;

	private Table<IndicatorPeriod, Instrument, TimeTwin> table;

}
