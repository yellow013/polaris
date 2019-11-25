package io.polaris.indicator.pools.base;

import org.eclipse.collections.api.list.MutableList;
import org.slf4j.Logger;

import io.ffreedom.common.collections.MutableLists;
import io.ffreedom.common.log.CommonLoggerFactory;
import io.polaris.financial.market.impl.BasicMarketData;
import io.polaris.indicator.base.BaseIndicator;

public abstract class BaseIndicatorPool<I extends BaseIndicator<?, ?>> {

	protected Logger logger = CommonLoggerFactory.getLogger(getClass());

	protected MutableList<I> indicators = MutableLists.newFastList();

	public void onMarketDate(BasicMarketData marketData) {
		indicators.forEach(indicator -> indicator.onMarketData(marketData));
	}

}
