package io.ffreedom.polaris.indicators.api;

import java.util.Optional;

import org.eclipse.collections.api.list.MutableList;

import io.ffreedom.common.collect.ECollections;

public final class PointSet<P> {

	private MutableList<P> points;

	private PointSet(int size) {
		this.points = ECollections.newFastList(size);
	}

	public static <P> PointSet<P> emptyPointSet() {
		return new PointSet<>(512);
	}

	public static <P> PointSet<P> emptyPointSet(int size) {
		return new PointSet<>(size);
	}

	public boolean add(P candle) {
		return points.add(candle);
	}

	public int size() {
		return points.size();
	}

	public P last() {
		return points.getLast();
	}

	public P first() {
		return points.getFirst();
	}

	public Optional<P> backtrack(int offset) {
		int indexOf = points.size() - offset - 1;
		return indexOf < 0 ? Optional.ofNullable(first()) : get(indexOf);
	}

	public Optional<P> get(int index) {
		return index < points.size() ? Optional.ofNullable(points.get(index)) : Optional.empty();
	}

	public Optional<P> nextOf(P currentCandle) {
		int indexOf = points.binarySearch(currentCandle);
		return get(indexOf++);
	}

	public MutableList<P> getPoints() {
		return points;
	}

}
