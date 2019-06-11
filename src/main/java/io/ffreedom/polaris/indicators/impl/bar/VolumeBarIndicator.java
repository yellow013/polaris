package io.ffreedom.polaris.indicators.impl.bar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import io.ffreedom.polaris.financial.Instrument;
import io.ffreedom.polaris.indicators.base.BaseRandomTimeIndicator;
import io.ffreedom.polaris.indicators.events.VolumeBarsEvent;
import io.ffreedom.polaris.market.impl.BasicMarketData;

public final class VolumeBarIndicator extends BaseRandomTimeIndicator<VolumeBar, VolumeBarsEvent> {

	// VolumeBar的计算成交量
	private long limitVolume;

	public VolumeBarIndicator(Instrument instrument, long limitVolume) {
		super(instrument);
		this.limitVolume = limitVolume;
		LocalTime startTime = instrument.getSymbol().getTradingPeriodSet().getFirstOptional().get().getStartTime();
		this.currentPoint = VolumeBar.with(0, instrument, LocalDateTime.of(LocalDate.now(), startTime), limitVolume);
	}

	@Override
	protected void handleMarketData(BasicMarketData marketData) {
		long remainingVolume = currentPoint.getRemainingVolume();
		long volume = marketData.getVolume();
		if(volume < remainingVolume) {
			
		}else {
			
		}

	}

}
