package io.polaris.indicator.events;

import io.polaris.indicator.api.IndicatorEvent;
import io.polaris.indicator.impl.bar.VolumeBar;

public interface VolumeBarsEvent extends IndicatorEvent {

	void onCurrentVolumeBarChanged(VolumeBar bar);

	void onStartVolumeBar(VolumeBar bar);

	void onEndVolumeBar(VolumeBar bar);

}
