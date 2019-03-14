package io.ffreedom.polaris.indicators.impl.ma;

import java.time.LocalDateTime;

import org.eclipse.collections.impl.set.mutable.UnifiedSet;

import io.ffreedom.polaris.indicators.impl.ma.base.MA;
import io.ffreedom.polaris.indicators.impl.ma.base.MAPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class SMA extends MA {

	public SMA(int period) {
		super(period);
	}

	public static void main(String[] args) {
		try {
			MAPoint point1 = MAPoint.with(null, LocalDateTime.now(), LocalDateTime.now());
			Thread.sleep(10);
			MAPoint point2 = MAPoint.with(null, LocalDateTime.now(), LocalDateTime.now());
			Thread.sleep(10);
			MAPoint point3 = MAPoint.with(null, LocalDateTime.now(), LocalDateTime.now());
			Thread.sleep(10);
			MAPoint point4 = MAPoint.with(null, LocalDateTime.now(), LocalDateTime.now());
			Thread.sleep(10);
			MAPoint point5 = MAPoint.with(null, LocalDateTime.now(), LocalDateTime.now());
			Thread.sleep(10);
			MAPoint point6 = MAPoint.with(null, LocalDateTime.now(), LocalDateTime.now());
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
	public void onMarketData(BasicMarketData marketData) {
		calculateContainer.updateTail(marketData.getLastPrice());
	}

}
