package io.ffreedom.polaris.indicators.base;

import org.eclipse.collections.api.list.MutableList;
import org.slf4j.Logger;

import io.ffreedom.common.collections.MutableLists;
import io.ffreedom.common.log.CommonLoggerFactory;
import io.ffreedom.common.sequence.Serial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.Indicator;
import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.api.Point;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public abstract class BaseIndicator<P extends Point<? extends Serial<?>>, E extends IndicatorEvent>
		implements Indicator<P, E> {

	protected Logger logger = CommonLoggerFactory.getLogger(getClass());

	// 指标对应的标的
	protected Instrument instrument;

	// 存储所有Point的集合
	protected PointSet<P> pointSet;

	// 当前Point
	protected P currentPoint;

	// 前一笔行情
	protected BasicMarketData preMarketData;

	// 存储事件的集合
	protected MutableList<E> events = MutableLists.newFastList(8);

	protected BaseIndicator(Instrument instrument) {
		this(instrument, 256);
	}

	protected BaseIndicator(Instrument instrument, int size) {
		this.instrument = instrument;
		this.pointSet = PointSet.newEmpty(size);
	}

	@Override
	public void addIndicatorEvent(E event) {
		if (event != null) {
			logger.info("Add IndicatorEvent -> name==[{}]", event.getEventName());
			events.add(event);
		}
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		handleMarketData(marketData);
		this.preMarketData = marketData;
	}

	protected abstract void handleMarketData(BasicMarketData marketData);

	@Override
	public Instrument getInstrument() {
		return instrument;
	}

	@Override
	public P getFastPoint() {
		if (pointSet.size() == 0)
			return currentPoint;
		return pointSet.getFirst();
	}

	@Override
	public P getCurrentPoint() {
		return currentPoint;
	}

	@Override
	public P getPoint(int index) {
		if (index < 0 || pointSet.size() == 0)
			return currentPoint;
		if (index >= pointSet.size())
			index = pointSet.size() - 1;
		return pointSet.get(index).orElse(currentPoint);
	}

	@Override
	public PointSet<P> getPointSet() {
		return pointSet;
	}

}
