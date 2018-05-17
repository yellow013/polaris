package io.ffreedom.indicators.impl.candle;

import java.util.Collection;

import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.impl.list.mutable.FastList;

public class CandleSet {

	private FastList<Candle> fastList;

	public CandleSet(int size) {
		this.fastList = FastList.newList(size);
	}

	public static CandleSet emptyCandleSet() {
		return new CandleSet(256);
	}

	public static CandleSet emptyCandleSet(int size) {
		return new CandleSet(size);
	}

	public boolean add(Candle bar) {

		return fastList.add(bar);
	}

	public ImmutableSortedSet<Candle> toImmutableSortedSet() {
		return fastList.toSortedSet().toImmutable();
	}

	public int size() {
		return fastList.size();
	}

	public Candle lastCandle() {
		return fastList.getLast();
	}

	public Candle firstCandle() {
		return fastList.getFirst();
	}

	public Candle backToCandle(int index) {
		int offset = fastList.size() - index - 1;
		return offset < 0 ? fastList.getFirst() : fastList.get(offset);
	}

	public static void main(String[] args) {

		FastList<Integer> list = FastList.newList(20);
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		System.out.println(list.size());
	}

	public Collection<Candle> toCollection() {
		return fastList;
	}

}
