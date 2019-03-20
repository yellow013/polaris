package io.ffreedom.polaris.indicators.api;

import java.util.Optional;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;

import io.ffreedom.common.collect.ECollections;

public final class PointSet<P extends Point<?, ?>> {

	private MutableLongObjectMap<P> pointMap;
	private MutableList<P> points;

	private PointSet(int size) {
		this.pointMap = ECollections.newLongObjectHashMap(size);
		this.points = ECollections.newFastList(size);
	}

	public static <P extends Point<?, ?>> PointSet<P> emptyPointSet() {
		return new PointSet<>(512);
	}

	public static <P extends Point<?, ?>> PointSet<P> emptyPointSet(int size) {
		return new PointSet<>(size);
	}

	public boolean add(P point) {
		return points.add(point);
	}

	public int size() {
		return points.size();
	}

	public P getLast() {
		return points.getLast();
	}

	public P getfirst() {
		return points.getFirst();
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

	public MutableList<P> getSubPoints(int fromIndex, int toIndex) {
		return points.subList(fromIndex, toIndex);
	}

}
