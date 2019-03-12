package io.ffreedom.polaris.market;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import io.ffreedom.common.datetime.TimeZones;
import io.ffreedom.polaris.financial.Instrument;

public class BasicMarketData {

	private ZonedDateTime zonedDateTime;
	private long epochMillis;
	private Instrument instrument;
	private double lastPrice;
	private double volume;
	private double turnover;
	private double bidPrice1;
	private double bidVolume1;
	private double askPrice1;
	private double askVolume1;

	private BasicMarketData() {
	}

	private BasicMarketData(Instrument instrument, long epochMillis) {
		this.instrument = instrument;
		this.epochMillis = epochMillis;
	}

	private BasicMarketData(Instrument instrument, ZonedDateTime zonedDateTime) {
		this.instrument = instrument;
		this.zonedDateTime = zonedDateTime;
		this.epochMillis = zonedDateTime.toInstant().toEpochMilli();
	}

	public static final BasicMarketData empty() {
		return new BasicMarketData();
	}

	public static final BasicMarketData of(Instrument instrument, long epochMillis) {
		return new BasicMarketData(instrument, epochMillis);
	}

	public static final BasicMarketData of(Instrument instrument, ZonedDateTime zonedDateTime) {
		return new BasicMarketData(instrument, zonedDateTime);
	}

	public ZonedDateTime getZonedDateTime() {
		if (zonedDateTime == null)
			zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(epochMillis), TimeZones.SYS_DEFAULT);
		return zonedDateTime;
	}

	public long getEpochMillis() {
		return epochMillis;
	}

	public BasicMarketData setEpochMillis(long epochMillis) {
		this.epochMillis = epochMillis;
		return this;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public BasicMarketData setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
		return this;
	}

	public double getVolume() {
		return volume;
	}

	public BasicMarketData setVolume(double volume) {
		this.volume = volume;
		return this;
	}

	public double getTurnover() {
		return turnover;
	}

	public BasicMarketData setTurnover(double turnover) {
		this.turnover = turnover;
		return this;
	}

	public double getBidPrice1() {
		return bidPrice1;
	}

	public BasicMarketData setBidPrice1(double bidPrice1) {
		this.bidPrice1 = bidPrice1;
		return this;
	}

	public double getBidVolume1() {
		return bidVolume1;
	}

	public BasicMarketData setBidVolume1(double bidVolume1) {
		this.bidVolume1 = bidVolume1;
		return this;
	}

	public double getAskPrice1() {
		return askPrice1;
	}

	public BasicMarketData setAskPrice1(double askPrice1) {
		this.askPrice1 = askPrice1;
		return this;
	}

	public double getAskVolume1() {
		return askVolume1;
	}

	public BasicMarketData setAskVolume1(double askVolume1) {
		this.askVolume1 = askVolume1;
		return this;
	}

	public static void main(String[] args) {

		LocalDate date = LocalDate.now();

		LocalTime time = LocalTime.now();

		LocalTime plus = time.plus(500, ChronoUnit.MILLIS);

		LocalDateTime dateTime = LocalDateTime.now();

		String format = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS"));

		System.out.println(date);

		System.out.println(plus);

		System.out.println(dateTime);

		System.out.println(format);

	}

}
