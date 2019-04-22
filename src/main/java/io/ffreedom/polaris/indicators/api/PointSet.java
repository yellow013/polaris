package io.ffreedom.polaris.indicators.api;

import java.util.Optional;

import javax.annotation.CheckForNull;
import javax.annotation.concurrent.NotThreadSafe;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;

import io.ffreedom.common.collect.MutableLists;
import io.ffreedom.common.collect.MutableMaps;

@NotThreadSafe
public final class PointSet<P extends Point<?, P>> {

	private MutableList<P> points;
	private MutableLongObjectMap<P> pointMap;

	private PointSet(int size) {
		this.points = MutableLists.newFastList(size);
		this.pointMap = MutableMaps.newLongObjectHashMap(size);
	}

	public static <P extends Point<?, P>> PointSet<P> newEmpty(int size) {
		return new PointSet<>(size);
	}

	public boolean add(P point) {
		long serialNumber = point.getXAxis().getSerialNumber();
		if (pointMap.containsKey(serialNumber))
			return false;
		pointMap.put(serialNumber, point);
		return points.add(point);
	}

	public int size() {
		return points.size();
	}

	public P getLast() {
		return points.getLast();
	}

	public P getFirst() {
		return points.getFirst();
	}

	public Optional<P> get(int index) {
		return index < points.size() ? Optional.ofNullable(points.get(index)) : Optional.empty();
	}

	public Optional<P> nextOf(P currentPoint) {
		int index = currentPoint.getIndex();
		if (++index < size())
			return get(index);
		P nextPoint = currentPoint.generateNext();
		if (nextPoint == null)
			return Optional.empty();
		pointMap.put(nextPoint.getXAxis().getSerialNumber(), nextPoint);
		points.add(nextPoint);
		return Optional.of(nextPoint);
	}

	@CheckForNull
	public P getPoint(long serialNumber) {
		return pointMap.get(serialNumber);
	}

	public MutableList<P> getPoints() {
		return points;
	}

	public MutableList<P> getSubPoints(int fromIndex, int toIndex) {
		return points.subList(fromIndex, toIndex);
	}

}
