package io.ffreedom.polaris.indicators.base;

import org.eclipse.collections.api.list.MutableList;
import org.slf4j.Logger;

import io.ffreedom.common.collect.MutableLists;
import io.ffreedom.common.log.CommonLoggerFactory;
import io.ffreedom.common.sequence.Serial;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.api.Indicator;
import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.api.Point;
import io.ffreedom.polaris.indicators.api.PointSet;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public abstract class BaseIndicator<P extends Point<? extends Serial<?>, P>, E extends IndicatorEvent>
		implements Indicator<P, E> {

	protected Logger logger = CommonLoggerFactory.getLogger(getClass());

	// 指标对应的标的
	protected Instrument instrument;

	// 存储所有Point的集合
	protected PointSet<P> points;
	// 当前Point
	protected P currentPoint;

	// 前一笔行情
	protected BasicMarketData preMarketData;

	protected BaseIndicator(Instrument instrument) {
		this(instrument, 256);
	}

	protected BaseIndicator(Instrument instrument, int size) {
		this.instrument = instrument;
		this.points = PointSet.newEmpty(size);
	}

	protected abstract void initialize();

	// 存储事件的集合
	private MutableList<E> indicatorEvents = MutableLists.newFastList(8);

	@Override
	public void addIndicatorEvent(E event) {
		if (event != null) {
			logger.info("Add IndicatorEvent -> name==[{}]", event.getEventName());
			indicatorEvents.add(event);
		}
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {
		handleMarketData(marketData);
		this.preMarketData = marketData;
	}

	protected abstract void handleMarketData(BasicMarketData marketData);

//	@Override
//	public void onMarketData(BasicMarketData marketData) {
//		if (isCurrentPointPeriod(marketData)) {
//			currentPoint.onMarketData(marketData);
//			currentPointChanged(currentPoint);
//		} else {
//			endPoint(currentPoint);
//			currentPoint = points.nextOf(currentPoint).orElseGet(() -> generateNextPoint(currentPoint));
//			while (!isCurrentPointPeriod(marketData)) {
//				currentPoint.onMarketData(preMarketData);
//				startPoint(currentPoint);
//				endPoint(currentPoint);
//				currentPoint = points.nextOf(currentPoint).orElseGet(() -> generateNextPoint(currentPoint));
//			}
//			currentPoint.onMarketData(marketData);
//			startPoint(currentPoint);
//		}
//		this.preMarketData = marketData;
//	}

	@Override
	public Instrument getInstrument() {
		return instrument;
	}

	@Override
	public P getFastPoint() {
		if (points.size() == 0)
			return currentPoint;
		return points.getFirst();
	}

	@Override
	public P getCurrentPoint() {
		return currentPoint;
	}

	@Override
	public P getPoint(int index) {
		if (index < 0 || points.size() == 0)
			return currentPoint;
		if (index >= points.size())
			index = points.size() - 1;
		return points.get(index).orElse(currentPoint);
	}

	@Override
	public PointSet<P> getPointSet() {
		return points;
	}

}
