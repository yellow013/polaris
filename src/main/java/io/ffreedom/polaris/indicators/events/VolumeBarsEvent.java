package io.ffreedom.polaris.indicators.events;

import io.ffreedom.polaris.indicators.api.IndicatorEvent;
import io.ffreedom.polaris.indicators.impl.bar.VolumeBar;

public interface VolumeBarsEvent extends IndicatorEvent {

	void onCurrentVolumeBarChanged(VolumeBar bar);

	void onStartVolumeBar(VolumeBar bar);

	void onEndVolumeBar(VolumeBar bar);

}
