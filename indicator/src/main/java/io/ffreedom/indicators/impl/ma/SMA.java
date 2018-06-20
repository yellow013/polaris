package io.ffreedom.indicators.impl.ma;

import java.time.LocalDateTime;

import org.eclipse.collections.impl.set.mutable.UnifiedSet;

import io.ffreedom.indicators.impl.ma.base.MA;
import io.ffreedom.indicators.impl.ma.base.MAPoint;
import io.ffreedom.market.data.MarketData;

public class SMA extends MA {

	public SMA(int period) {
		super(period);
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public MAPoint getPoint(int i) {
		return null;
	}

	public static void main(String[] args) {
		try {

			MAPoint point1 = new MAPoint(LocalDateTime.now(), LocalDateTime.now());
			Thread.sleep(10);
			MAPoint point2 = new MAPoint(LocalDateTime.now(), LocalDateTime.now());
			Thread.sleep(10);
			MAPoint point3 = new MAPoint(LocalDateTime.now(), LocalDateTime.now());
			Thread.sleep(10);
			MAPoint point4 = new MAPoint(LocalDateTime.now(), LocalDateTime.now());
			Thread.sleep(10);
			MAPoint point5 = new MAPoint(LocalDateTime.now(), LocalDateTime.now());
			Thread.sleep(10);
			MAPoint point6 = new MAPoint(LocalDateTime.now(), LocalDateTime.now());
			Thread.sleep(10);
			// FastList<MAPoint> fastList = FastList.newListWith(point3, point2, point1,
			// point5, point4, point6);
			UnifiedSet<MAPoint> unifiedSet = UnifiedSet.newSetWith(point3, point2, point1, point5, point4, point6);

			unifiedSet.forEach(e -> System.out.println(e.getXAxis() + " - " + e.getYAxis()));

			// FastList<MAPoint> sortThis = fastList.sortThis();

			// System.out.println(fastList.hashCode());

			// System.out.println(sortThis.hashCode());

			// sortThis.forEach(e -> System.out.println(e.getXAxis() + " - " +
			// e.getYAxis()));

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onMarketData(MarketData marketData) {
		calculateContainer.updateTail(marketData.getLastPrice());
	}

	@Override
	public void endPoint(MAPoint p) {
		// TODO Auto-generated method stub

	}

}
