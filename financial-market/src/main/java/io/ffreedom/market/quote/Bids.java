package io.ffreedom.market.quote;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;

public class Bids {

	private MutableSortedSet<BidQuote> bidQuotes = TreeSortedSet.newSet();

	private Bids() {
		
	}

	public static Bids newInstance() {
		return new Bids();
	}

	public ImmutableSortedSet<BidQuote> getAskQuotes() {
		return bidQuotes.toImmutable();
	}

	public Bids addBidQuote(double price, double volume) {
		bidQuotes.add(new BidQuote(price, volume));
		return this;
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

}
