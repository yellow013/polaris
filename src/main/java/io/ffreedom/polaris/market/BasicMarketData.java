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

/**
 * @author yellow013
 * @creation 2019年5月24日
 */
public class BasicMarketData {

	private Instrument instrument;
	private long epochMillis;
	private ZonedDateTime zonedDateTime;
	private double lastPrice;
	private long volume;
	private double turnover;
	/** bid level 10 **/
	private double bidPrice1;
	private long bidVolume1;
	private double bidPrice2;
	private long bidVolume2;
	private double bidPrice3;
	private long bidVolume3;
	private double bidPrice4;
	private long bidVolume4;
	private double bidPrice5;
	private long bidVolume5;
	private double bidPrice6;
	private long bidVolume6;
	private double bidPrice7;
	private long bidVolume7;
	private double bidPrice8;
	private long bidVolume8;
	private double bidPrice9;
	private long bidVolume9;
	private double bidPrice10;
	private long bidVolume10;
	/** ask level 10 **/
	private double askPrice1;
	private long askVolume1;
	private double askPrice2;
	private long askVolume2;
	private double askPrice3;
	private long askVolume3;
	private double askPrice4;
	private long askVolume4;
	private double askPrice5;
	private long askVolume5;
	private double askPrice6;
	private long askVolume6;
	private double askPrice7;
	private long askVolume7;
	private double askPrice8;
	private long askVolume8;
	private double askPrice9;
	private long askVolume9;
	private double askPrice10;
	private long askVolume10;

	private BasicMarketData() {
	}

	private BasicMarketData(Instrument instrument, long epochMillis) {
		this.epochMillis = epochMillis;
		this.instrument = instrument;
	}

	public BasicMarketData(Instrument instrument, ZonedDateTime zonedDateTime) {
		super();
		this.instrument = instrument;
		this.zonedDateTime = zonedDateTime;
	}

	private BasicMarketData(Instrument instrument, long epochMillis, double lastPrice, long volume, double turnover) {
		this.epochMillis = epochMillis;
		this.instrument = instrument;
		this.lastPrice = lastPrice;
		this.volume = volume;
		this.turnover = turnover;
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

	public static final BasicMarketData of(Instrument instrument, long epochMillis, double lastPrice, long volume,
			double turnover) {
		return new BasicMarketData(instrument, epochMillis, lastPrice, volume, turnover);
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public long getEpochMillis() {
		return epochMillis;
	}

	public ZonedDateTime getZonedDateTime() {
		if (zonedDateTime == null)
			zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(epochMillis), TimeZones.SYS_DEFAULT);
		return zonedDateTime;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public long getVolume() {
		return volume;
	}

	public double getTurnover() {
		return turnover;
	}

	public double getBidPrice1() {
		return bidPrice1;
	}

	public long getBidVolume1() {
		return bidVolume1;
	}

	public double getBidPrice2() {
		return bidPrice2;
	}

	public long getBidVolume2() {
		return bidVolume2;
	}

	public double getBidPrice3() {
		return bidPrice3;
	}

	public long getBidVolume3() {
		return bidVolume3;
	}

	public double getBidPrice4() {
		return bidPrice4;
	}

	public long getBidVolume4() {
		return bidVolume4;
	}

	public double getBidPrice5() {
		return bidPrice5;
	}

	public long getBidVolume5() {
		return bidVolume5;
	}

	public double getBidPrice6() {
		return bidPrice6;
	}

	public long getBidVolume6() {
		return bidVolume6;
	}

	public double getBidPrice7() {
		return bidPrice7;
	}

	public long getBidVolume7() {
		return bidVolume7;
	}

	public double getBidPrice8() {
		return bidPrice8;
	}

	public long getBidVolume8() {
		return bidVolume8;
	}

	public double getBidPrice9() {
		return bidPrice9;
	}

	public long getBidVolume9() {
		return bidVolume9;
	}

	public double getBidPrice10() {
		return bidPrice10;
	}

	public long getBidVolume10() {
		return bidVolume10;
	}

	public double getAskPrice1() {
		return askPrice1;
	}

	public long getAskVolume1() {
		return askVolume1;
	}

	public double getAskPrice2() {
		return askPrice2;
	}

	public long getAskVolume2() {
		return askVolume2;
	}

	public double getAskPrice3() {
		return askPrice3;
	}

	public long getAskVolume3() {
		return askVolume3;
	}

	public double getAskPrice4() {
		return askPrice4;
	}

	public long getAskVolume4() {
		return askVolume4;
	}

	public double getAskPrice5() {
		return askPrice5;
	}

	public long getAskVolume5() {
		return askVolume5;
	}

	public double getAskPrice6() {
		return askPrice6;
	}

	public long getAskVolume6() {
		return askVolume6;
	}

	public double getAskPrice7() {
		return askPrice7;
	}

	public long getAskVolume7() {
		return askVolume7;
	}

	public double getAskPrice8() {
		return askPrice8;
	}

	public long getAskVolume8() {
		return askVolume8;
	}

	public double getAskPrice9() {
		return askPrice9;
	}

	public long getAskVolume9() {
		return askVolume9;
	}

	public double getAskPrice10() {
		return askPrice10;
	}

	public long getAskVolume10() {
		return askVolume10;
	}

	public BasicMarketData setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
		return this;
	}

	public BasicMarketData setVolume(long volume) {
		this.volume = volume;
		return this;
	}

	public BasicMarketData setTurnover(double turnover) {
		this.turnover = turnover;
		return this;
	}

	public BasicMarketData setBidPrice1(double bidPrice1) {
		this.bidPrice1 = bidPrice1;
		return this;
	}

	public BasicMarketData setBidVolume1(long bidVolume1) {
		this.bidVolume1 = bidVolume1;
		return this;
	}

	public BasicMarketData setBidPrice2(double bidPrice2) {
		this.bidPrice2 = bidPrice2;
		return this;
	}

	public BasicMarketData setBidVolume2(long bidVolume2) {
		this.bidVolume2 = bidVolume2;
		return this;
	}

	public BasicMarketData setBidPrice3(double bidPrice3) {
		this.bidPrice3 = bidPrice3;
		return this;
	}

	public BasicMarketData setBidVolume3(long bidVolume3) {
		this.bidVolume3 = bidVolume3;
		return this;
	}

	public BasicMarketData setBidPrice4(double bidPrice4) {
		this.bidPrice4 = bidPrice4;
		return this;
	}

	public BasicMarketData setBidVolume4(long bidVolume4) {
		this.bidVolume4 = bidVolume4;
		return this;
	}

	public BasicMarketData setBidPrice5(double bidPrice5) {
		this.bidPrice5 = bidPrice5;
		return this;
	}

	public BasicMarketData setBidVolume5(long bidVolume5) {
		this.bidVolume5 = bidVolume5;
		return this;
	}

	public BasicMarketData setBidPrice6(double bidPrice6) {
		this.bidPrice6 = bidPrice6;
		return this;
	}

	public BasicMarketData setBidVolume6(long bidVolume6) {
		this.bidVolume6 = bidVolume6;
		return this;
	}

	public BasicMarketData setBidPrice7(double bidPrice7) {
		this.bidPrice7 = bidPrice7;
		return this;
	}

	public BasicMarketData setBidVolume7(long bidVolume7) {
		this.bidVolume7 = bidVolume7;
		return this;
	}

	public BasicMarketData setBidPrice8(double bidPrice8) {
		this.bidPrice8 = bidPrice8;
		return this;
	}

	public BasicMarketData setBidVolume8(long bidVolume8) {
		this.bidVolume8 = bidVolume8;
		return this;
	}

	public BasicMarketData setBidPrice9(double bidPrice9) {
		this.bidPrice9 = bidPrice9;
		return this;
	}

	public BasicMarketData setBidVolume9(long bidVolume9) {
		this.bidVolume9 = bidVolume9;
		return this;
	}

	public BasicMarketData setBidPrice10(double bidPrice10) {
		this.bidPrice10 = bidPrice10;
		return this;
	}

	public BasicMarketData setBidVolume10(long bidVolume10) {
		this.bidVolume10 = bidVolume10;
		return this;
	}

	public BasicMarketData setAskPrice1(double askPrice1) {
		this.askPrice1 = askPrice1;
		return this;
	}

	public BasicMarketData setAskVolume1(long askVolume1) {
		this.askVolume1 = askVolume1;
		return this;
	}

	public BasicMarketData setAskPrice2(double askPrice2) {
		this.askPrice2 = askPrice2;
		return this;
	}

	public BasicMarketData setAskVolume2(long askVolume2) {
		this.askVolume2 = askVolume2;
		return this;
	}

	public BasicMarketData setAskPrice3(double askPrice3) {
		this.askPrice3 = askPrice3;
		return this;
	}

	public BasicMarketData setAskVolume3(long askVolume3) {
		this.askVolume3 = askVolume3;
		return this;
	}

	public BasicMarketData setAskPrice4(double askPrice4) {
		this.askPrice4 = askPrice4;
		return this;
	}

	public BasicMarketData setAskVolume4(long askVolume4) {
		this.askVolume4 = askVolume4;
		return this;
	}

	public BasicMarketData setAskPrice5(double askPrice5) {
		this.askPrice5 = askPrice5;
		return this;
	}

	public BasicMarketData setAskVolume5(long askVolume5) {
		this.askVolume5 = askVolume5;
		return this;
	}

	public BasicMarketData setAskPrice6(double askPrice6) {
		this.askPrice6 = askPrice6;
		return this;
	}

	public BasicMarketData setAskVolume6(long askVolume6) {
		this.askVolume6 = askVolume6;
		return this;
	}

	public BasicMarketData setAskPrice7(double askPrice7) {
		this.askPrice7 = askPrice7;
		return this;
	}

	public BasicMarketData setAskVolume7(long askVolume7) {
		this.askVolume7 = askVolume7;
		return this;
	}

	public BasicMarketData setAskPrice8(double askPrice8) {
		this.askPrice8 = askPrice8;
		return this;
	}

	public BasicMarketData setAskVolume8(long askVolume8) {
		this.askVolume8 = askVolume8;
		return this;
	}

	public BasicMarketData setAskPrice9(double askPrice9) {
		this.askPrice9 = askPrice9;
		return this;
	}

	public BasicMarketData setAskVolume9(long askVolume9) {
		this.askVolume9 = askVolume9;
		return this;
	}

	public BasicMarketData setAskPrice10(double askPrice10) {
		this.askPrice10 = askPrice10;
		return this;
	}

	public BasicMarketData setAskVolume10(long askVolume10) {
		this.askVolume10 = askVolume10;
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
