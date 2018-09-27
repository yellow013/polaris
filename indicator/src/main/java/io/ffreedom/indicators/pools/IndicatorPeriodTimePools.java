package io.ffreedom.indicators.pools;

import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.set.MutableSet;

import io.ffreedom.financial.Instrument;
import io.ffreedom.indicators.api.IndicatorPeriod;
import io.ffreedom.market.TimeTwin;

//TODO 池化时间分割机制
public final class IndicatorPeriodTimePools {

	private boolean isInit;

	private MutableIntObjectMap<MutableIntObjectMap<MutableSet<TimeTwin>>> pools;

}
