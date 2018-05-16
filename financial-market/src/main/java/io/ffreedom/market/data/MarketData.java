package io.ffreedom.market.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import io.ffreedom.financial.Instrument;

public class MarketData {

	private LocalDate date;
	private LocalTime time;
	private Instrument instrument;
	private Asks asks;
	private Bids bids;

	public MarketData(LocalDate date, LocalTime time, Instrument instrument) {
		this.date = date;
		this.time = time;
		this.instrument = instrument;
		this.asks = Asks.newInstance();
		this.bids = Bids.newInstance();
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getTime() {
		return time;
	}

	public Asks getAsks() {
		return asks;
	}

	public Bids getBids() {
		return bids;
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
