package io.polaris.indicators.events;

import io.polaris.indicators.api.IndicatorEvent;
import io.polaris.indicators.impl.bar.VolumeBar;

public interface VolumeBarsEvent extends IndicatorEvent {

	void onCurrentVolumeBarChanged(VolumeBar bar);

	void onStartVolumeBar(VolumeBar bar);

	void onEndVolumeBar(VolumeBar bar);

}
