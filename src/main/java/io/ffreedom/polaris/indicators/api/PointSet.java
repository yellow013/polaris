package io.ffreedom.polaris.indicators.api;

import java.util.Optional;

import javax.annotation.CheckForNull;
import javax.annotation.concurrent.NotThreadSafe;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;

import io.ffreedom.common.collections.MutableLists;
import io.ffreedom.common.collections.MutableMaps;
import io.ffreedom.common.sequence.Serial;

@NotThreadSafe
public final class PointSet<P extends Point<? extends Serial<?>>> {

	private MutableList<P> points;
	private MutableLongObjectMap<P> pointMap;

	private PointSet(int size) {
		this.points = MutableLists.newFastList(size);
		this.pointMap = MutableMaps.newLongObjectHashMap(size);
	}

	public static <P extends Point<? extends Serial<?>>> PointSet<P> newEmpty(int size) {
		return new PointSet<>(size);
	}

	public boolean add(P point) {
		long serialNumber = point.getSerial().getSerialNumber();
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

	public Optional<P> nextOf(P point) {
		int index = point.getIndex();
		return get(++index);
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
