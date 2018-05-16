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
	public void onTick(MarketData marketData) {
		updateAvgPrice(0.0D);

	}

	@Override
	public void onPoint(MAPoint p) {
		// MAPoint point = new MAPoint(bar.getStartDateTime(), bar.getClose());
		// calculateList.addTail(point);

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MAPoint getPoint(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		try {

			MAPoint point1 = new MAPoint(LocalDateTime.now(), 1.0);
			Thread.sleep(10);
			MAPoint point2 = new MAPoint(LocalDateTime.now(), 2.0);
			Thread.sleep(10);
			MAPoint point3 = new MAPoint(LocalDateTime.now(), 3.0);
			Thread.sleep(10);
			MAPoint point4 = new MAPoint(LocalDateTime.now(), 4.0);
			Thread.sleep(10);
			MAPoint point5 = new MAPoint(LocalDateTime.now(), 5.0);
			Thread.sleep(10);
			MAPoint point6 = new MAPoint(LocalDateTime.now(), 6.0);
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

}
