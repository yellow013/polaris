package io.ffreedom.polaris.market;

import java.util.NoSuchElementException;

public final class Quotes {

	private AskQuote[] askQuotes;
	private BidQuote[] bidQuotes;

	private int askLevel;
	private int askLevelIndex = 0;

	private int bidLevel;
	private int bidLevelIndex = 0;

	private Quotes(int askLevel, int bidLevel) {
		this.askLevel = askLevel;
		this.bidLevel = bidLevel;
		this.askQuotes = new AskQuote[askLevel];
		this.bidQuotes = new BidQuote[bidLevel];
	}

	public static Quotes newInstance() {
		return new Quotes(10, 10);
	}

	public static Quotes newInstance(int level) {
		return new Quotes(level, level);
	}

	public static Quotes newInstance(int askLevel, int bidLevel) {
		return new Quotes(askLevel, bidLevel);
	}

	public AskQuote[] getAskQuotes() {
		return askQuotes;
	}

	public BidQuote[] getBidQuotes() {
		return bidQuotes;
	}

	public Quotes addQuote(double price, double volume, QuoteType type) throws QuoteLevelOverflowException {
		switch (type) {
		case Bid:
			return addBidQuote(price, volume);
		case Ask:
			return addAskQuote(price, volume);
		default:
			throw new NoSuchElementException("QuoteType -> (" + type + ") is");
		}
	}

	public Quotes addAskQuote(double price, double volume) throws QuoteLevelOverflowException {
		if (askLevelIndex == askLevel)
			throw new QuoteLevelOverflowException(
					"askLevelIndex == " + askLevelIndex + ", array length is " + askLevel);
		askQuotes[askLevelIndex] = new AskQuote(price, volume);
		askLevelIndex++;
		return this;
	}

	public Quotes addBidQuote(double price, double volume) throws QuoteLevelOverflowException {
		if (bidLevelIndex == bidLevel)
			throw new QuoteLevelOverflowException(
					"bidLevelIndex == " + bidLevelIndex + ", array length is " + bidLevel);
		bidQuotes[bidLevelIndex] = new BidQuote(price, volume);
		bidLevelIndex++;
		return this;
	}

	public static class AskQuote extends Quote {

		private AskQuote(double price, double volume) {
			super(price, volume);
		}

		@Override
		public int compareTo(Quote o) {
			return getPrice() < o.getPrice() ? -1 : getPrice() > o.getPrice() ? 1 : 0;
		}

		@Override
		public QuoteType getType() {
			return QuoteType.Ask;
		}

	}

	public static class BidQuote extends Quote {

		private BidQuote(double price, double volume) {
			super(price, volume);
		}

		@Override
		public int compareTo(Quote o) {
			return getPrice() > o.getPrice() ? -1 : getPrice() < o.getPrice() ? 1 : 0;
		}

		@Override
		public QuoteType getType() {
			return QuoteType.Bid;
		}

	}

	public static enum QuoteType {
		Bid, Ask
	}

	private static abstract class Quote implements Comparable<Quote> {

		private double price;
		private double volume;

		protected Quote(double price, double volume) {
			this.price = price;
			this.volume = volume;
		}

		public double getPrice() {
			return price;
		}

		public double getVolume() {
			return volume;
		}

		public abstract QuoteType getType();
	}

}