package io.ffreedom.polaris.pools;

import javax.annotation.concurrent.ThreadSafe;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.eclipse.collections.api.map.ConcurrentMutableMap;

import io.ffreedom.common.collect.MutableMaps;

@ThreadSafe
public final class SummaryStatisticsPool {

	private static ConcurrentMutableMap<Thread, SummaryStatistics> summaryStatisticsMap = MutableMaps
			.newConcurrentHashMap();

	public static SummaryStatistics getSummaryStatistics() {
		return getSummaryStatistics(Thread.currentThread());
	}

	public static SummaryStatistics getSummaryStatistics(Thread currentThread) {
		SummaryStatistics summaryStatistics = summaryStatisticsMap.get(currentThread);
		if (summaryStatistics == null) {
			summaryStatistics = new SummaryStatistics();
			summaryStatisticsMap.put(currentThread, summaryStatistics);
		}
		return summaryStatistics;
	}

}
