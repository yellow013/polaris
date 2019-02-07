package io.ffreedom.polaris.indicators.impl.ma.base;

import org.eclipse.collections.api.list.primitive.ImmutableDoubleList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.impl.list.mutable.primitive.MutableDoubleListFactoryImpl;

public class MACalculateContainer {

	private MutableDoubleList calculateList = MutableDoubleListFactoryImpl.INSTANCE.empty();

	private int head = 0;
	private int tail = 0;
	private int count = 0;

	private int capacity;

	public static MACalculateContainer newContainer(int capacity) {
		return new MACalculateContainer(capacity);
	}

	private MACalculateContainer(int capacity) {
		this.capacity = capacity;
	}

	private void updateTailIndex() {
		if (++tail == capacity) {
			tail = 0;
		}
	}

	private void updateHeadIndex() {
		if (count == capacity) {
			if (++head == capacity) {
				head = 0;
			}
		}
	}

	private void updateCount() {
		if (count < capacity) {
			count++;
		}
	}

	public ImmutableDoubleList getCalculateList() {
		return calculateList.toImmutable();
	}

	public MACalculateContainer addTail(double value) {
		updateTailIndex();
		updateTail(value);
		updateHeadIndex();
		updateCount();
		return this;
	}

	public MACalculateContainer updateTail(double value) {
		calculateList.set(tail, value);
		return this;
	}

	public MACalculateContainer removeHead() {
		calculateList.removeAtIndex(head);
		return this;
	}

	public double sum() {
		return calculateList.sum();
	}

	public double max() {
		return calculateList.max();
	}

	public double min() {
		return calculateList.min();
	}

	public double average() {
		return calculateList.average();
	}

	public double median() {
		return calculateList.median();
	}

	public static void main(String[] args) {

		MACalculateContainer container = new MACalculateContainer(10);

		ImmutableDoubleList list = container.getCalculateList();

		System.out.println(list.median());

		System.out.println(list.average());

		System.out.println(list.sum());

		System.out.println(list.median());

		System.out.println(list.average());

		System.out.println(list.sum());
	}
}
