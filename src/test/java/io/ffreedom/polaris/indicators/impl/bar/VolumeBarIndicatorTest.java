package io.ffreedom.polaris.indicators.impl.bar;

import org.junit.Test;

import io.ffreedom.polaris.financial.Instrument.PriorityCloseType;
import io.ffreedom.polaris.financial.futures.ChinaFutures;
import io.ffreedom.polaris.financial.futures.ChinaFuturesSymbol;

public class VolumeBarIndicatorTest {

	@Test
	public void test() {

		// TODO 读取数据文件

		ChinaFutures rb1910 = ChinaFutures.build(ChinaFuturesSymbol.RB, 1910, PriorityCloseType.BEFORE_TODAY);

		VolumeBarIndicator indicator = new VolumeBarIndicator(rb1910, 2000);

		indicator.onMarketData(null);

	}

}
