package io.ffreedom.indicators.impl.candle;

import java.util.Collection;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.impl.list.mutable.FastList;

public class CandleSet {

	private MutableList<Candle> candleList;
	
	private CandleSet(int size) {
		this.candleList = FastList.newList(size);
	}

	public static CandleSet emptyCandleSet() {
		return new CandleSet(512);
	}

	public static CandleSet emptyCandleSet(int size) {
		return new CandleSet(size);
	}

	public boolean add(Candle candle) {
		return candleList.add(candle);
	}

	public int size() {
		return candleList.size();
	}

	public Candle lastCandle() {
		return candleList.getLast();
	}

	public Candle firstCandle() {
		return candleList.getFirst();
	}

	public Candle backtrack(int index) {
		int offset = candleList.size() - index - 1;
		return offset < 0 ? firstCandle() : getCandle(offset);
	}
	
	public Candle getCandle(int index) {
		return candleList.get(index);
	}
	
	public Candle getNextCandle(Candle currentCandle) {
		int indexOf = candleList.indexOf(currentCandle);
		indexOf++;
		return indexOf < candleList.size() ? candleList.get(indexOf) : 
	}

	public Collection<Candle> toCollection() {
		return candleList;
	}

	public ImmutableSortedSet<Candle> toImmutableSortedSet() {
		return candleList.toSortedSet().toImmutable();
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
