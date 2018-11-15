package io.ffreedom.market;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import io.ffreedom.financial.Instrument;

public final class MarketData2 {

	private LocalDateTime datetime;
	private Instrument instrument;
	private double lastPrice;
	private double volume;
	private double turnover;
	private Quotes quotes;

	public MarketData2(LocalDateTime datetime, Instrument instrument, int quoteLevel) {
		this.datetime = datetime;
		this.instrument = instrument;
		quotes = Quotes.newInstance(quoteLevel);
	}

	public MarketData2(LocalDate date, LocalTime time, Instrument instrument, int quoteLevel) {
		this(LocalDateTime.of(date, time), instrument, quoteLevel);
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public MarketData2 setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
		return this;
	}

	public double getVolume() {
		return volume;
	}

	public MarketData2 setVolume(double volume) {
		this.volume = volume;
		return this;
	}

	public double getTurnover() {
		return turnover;
	}

	public MarketData2 setTurnover(double turnover) {
		this.turnover = turnover;
		return this;
	}

	public Quotes getQuotes() {
		return quotes;
	}

	public MarketData2 addAskQuote(double price, double volume) throws QuoteLevelOverflowException {
		quotes.addAskQuote(price, volume);
		return this;
	}

	public MarketData2 addBidQuote(double price, double volume) throws QuoteLevelOverflowException {
		quotes.addBidQuote(price, volume);
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
