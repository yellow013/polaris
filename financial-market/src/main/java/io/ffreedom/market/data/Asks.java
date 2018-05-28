package io.ffreedom.market.data;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;

public final class Asks {

	private MutableSortedSet<AskQuote> askQuotes = TreeSortedSet.newSet();

	private Asks() {
	}

	static Asks newInstance() {
		return new Asks();
	}

	public ImmutableSortedSet<AskQuote> getAskQuotes() {
		return askQuotes.toImmutable();
	}

	public Asks addAskQuote(double price, double volume) {
		askQuotes.add(new AskQuote(price, volume));
		return this;
	}

	public static class AskQuote extends Quotes {

		private AskQuote(double price, double volume) {
			super(price, volume);
		}

		@Override
		public int compareTo(Quotes o) {
			return getPrice() < o.getPrice() ? -1 : getPrice() > o.getPrice() ? 1 : 0;
		}

		@Override
		public QuoteType getType() {
			return QuoteType.Ask;
		}

	}

}
