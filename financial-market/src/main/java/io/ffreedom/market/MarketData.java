package io.ffreedom.market;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import io.ffreedom.financial.Instrument;

public class MarketData {

	private LocalDateTime datetime;
	private Instrument instrument;
	private double lastPrice;
	private double volume;
	private double turnover;
	private Asks asks;
	private Bids bids;

	public MarketData(LocalDateTime datetime, Instrument instrument) {
		this.datetime = datetime;
		this.instrument = instrument;
		this.asks = Asks.newInstance();
		this.bids = Bids.newInstance();
	}

	public MarketData(LocalDate date, LocalTime time, Instrument instrument) {
		this(LocalDateTime.of(date, time), instrument);
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public MarketData setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
		return this;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public MarketData setInstrument(Instrument instrument) {
		this.instrument = instrument;
		return this;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public MarketData setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
		return this;
	}

	public double getVolume() {
		return volume;
	}

	public MarketData setVolume(double volume) {
		this.volume = volume;
		return this;
	}

	public double getTurnover() {
		return turnover;
	}

	public MarketData setTurnover(double turnover) {
		this.turnover = turnover;
		return this;
	}

	public Asks getAsks() {
		return asks;
	}

	public Bids getBids() {
		return bids;
	}

	public MarketData addAskQuote(double price, double volume) {
		asks.addAskQuote(price, volume);
		return this;
	}

	public MarketData addBidQuote(double price, double volume) {
		bids.addBidQuote(price, volume);
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
