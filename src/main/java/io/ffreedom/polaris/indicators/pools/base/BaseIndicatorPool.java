package io.ffreedom.polaris.indicators.pools.base;

import org.eclipse.collections.api.list.MutableList;
import org.slf4j.Logger;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.common.log.CommonLoggerFactory;
import io.ffreedom.polaris.indicators.impl.AbstractPooledIndicator;
import io.ffreedom.polaris.market.BasicMarketData;

public abstract class BaseIndicatorPool<I extends AbstractPooledIndicator<?, ?>> {

	protected Logger logger = CommonLoggerFactory.getLogger(getClass());

	protected MutableList<I> indicators = ECollections.newFastList();

	public void onMarketDate(BasicMarketData marketData) {
		indicators.forEach(indicator -> indicator.onMarketData(marketData));
	}

}
