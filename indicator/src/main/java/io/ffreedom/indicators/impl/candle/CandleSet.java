package io.ffreedom.indicators.impl.candle;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.impl.list.mutable.FastList;

public class CandleSet {

	private MutableList<Candle> candles;

	private CandleSet(int size) {
		this.candles = FastList.newList(size);
	}

	public static CandleSet emptyCandleSet() {
		return new CandleSet(512);
	}

	public static CandleSet emptyCandleSet(int size) {
		return new CandleSet(size);
	}

	public boolean add(Candle candle) {
		return candles.add(candle);
	}

	public int size() {
		return candles.size();
	}

	public Candle lastCandle() {
		return candles.getLast();
	}

	public Candle firstCandle() {
		return candles.getFirst();
	}

	public Candle backtrack(int index) {
		int offset = candles.size() - index - 1;
		return offset < 0 ? firstCandle() : getCandle(offset);
	}

	public Candle getCandle(int index) {
		return candles.get(index);
	}

	public Optional<Candle> getNextCandle(Candle currentCandle) {
		int indexOf = candles.binarySearch(currentCandle);
		return (indexOf++) < candles.size() ? Optional.of(getCandle(indexOf)) : Optional.empty();
	}

	public Collection<Candle> toCollection() {
		return candles;
	}

	public ImmutableSortedSet<Candle> toImmutableSortedSet() {
		return candles.toSortedSet().toImmutable();
	}

	public static void main(String[] args) {

		FastList<Integer> list = FastList.newList(500);

		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		System.out.println(list.size());
		System.out.println(list.indexOf(list.get(9)));

	}

}
