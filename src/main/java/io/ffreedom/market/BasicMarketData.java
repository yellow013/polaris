package io.ffreedom.market;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BasicMarketData {

	private LocalDate tradingDay;
	private long epochMillis;
	private int instrumentId;
	private double lastPrice;
	private double volume;
	private double turnover;
	private double bidPrice1;
	private double bidVolume1;
	private double askPrice1;
	private double askVolume1;

	public BasicMarketData(long epochMillis, int instrumentId) {
		this.instrumentId = instrumentId;
	}

	public LocalDate getTradingDay() {
		return tradingDay;
	}

	public BasicMarketData setTradingDay(LocalDate tradingDay) {
		this.tradingDay = tradingDay;
		return this;
	}

	public long getEpochMillis() {
		return epochMillis;
	}

	public BasicMarketData setEpochMillis(long epochMillis) {
		this.epochMillis = epochMillis;
		return this;
	}

	public int getInstrumentId() {
		return instrumentId;
	}

	public BasicMarketData setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
		return this;
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
