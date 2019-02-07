package io.ffreedom.polaris.indicators.api;

import java.time.Duration;
import java.time.LocalTime;

public enum IndicatorPeriod {

	S1(Duration.ofSeconds(1)),

	S2(Duration.ofSeconds(2)),

	S5(Duration.ofSeconds(5)),

	S10(Duration.ofSeconds(10)),

	S15(Duration.ofSeconds(15)),

	S30(Duration.ofSeconds(30)),

	M1(Duration.ofMinutes(1)),

	M2(Duration.ofMinutes(2)),

	M5(Duration.ofMinutes(5)),

	M10(Duration.ofMinutes(10)),

	M15(Duration.ofMinutes(15)),

	M30(Duration.ofMinutes(30)),

	H1(Duration.ofHours(1)),

	H2(Duration.ofHours(2)),

	H4(Duration.ofHours(4)),

	D1(Duration.ofDays(1));

	private Duration duration;

	private IndicatorPeriod(Duration duration) {
		this.duration = duration;
	}

	public Duration getDuration() {
		return duration;
	}

	public long getSeconds() {
		return duration.getSeconds();
	}

	public static void main(String[] args) {
		for (IndicatorPeriod period : IndicatorPeriod.values()) {
			System.out.println(period.getSeconds());
			LocalTime plusSeconds = LocalTime.of(21, 0, 0).plusSeconds(period.getSeconds());
			System.out.println(plusSeconds);
		}

	}

}