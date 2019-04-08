package io.ffreedom.polaris.indicators.impl.bar.point;

import java.time.LocalDateTime;

import org.eclipse.collections.api.list.primitive.MutableDoubleList;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.common.utils.DoubleUtil;
import io.ffreedom.polaris.datetime.TimeStarted;
import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.impl.TimeStartedPoint;
import io.ffreedom.polaris.market.BasicMarketData;

public class VolumeBar extends TimeStartedPoint<VolumeBar> {

	private double open = Double.NaN;
	private double highest = Double.MIN_VALUE;
	private double lowest = Double.MAX_VALUE;
	private double close = Double.NaN;
	private double volumeSum = 0.0D;
	private double turnoverSum = 0.0D;
	private MutableDoubleList priceRecord = ECollections.newDoubleArrayList(64);

	private double volumeLimit;

	private VolumeBar(int index, Instrument instrument, TimeStarted timeStarted, double volumeLimit) {
		super(index, instrument, timeStarted);
		this.volumeLimit = volumeLimit;

	}

	public static VolumeBar with(int index, Instrument instrument, LocalDateTime datetime, double volumeLimit) {
		return new VolumeBar(index, instrument, TimeStarted.with(datetime), volumeLimit);
	}

	@Override
	public VolumeBar generateNext() {

		return null;
	}

	@Override
	public void onMarketData(BasicMarketData marketData) {

	}

	private void onPrice(double price) {
		close = price;
		if (Double.isNaN(open))
			open = price;
		if (price < lowest)
			lowest = price;
		if (price > highest)
			highest = price;
		priceRecord.add(price);
	}

	private void addVolumeSum(double volume) {
		this.volumeSum = DoubleUtil.correction8(volumeSum + volume);
	}

	private void addTurnoverSum(double turnover) {
		this.turnoverSum = DoubleUtil.correction8(turnoverSum + turnover);
	}

	@Override
	protected VolumeBar thisPoint() {
		return this;
	}

}
