package io.ffreedom.polaris.indicators.impl;

import org.eclipse.collections.api.list.primitive.ImmutableDoubleList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;

import io.ffreedom.common.collect.ECollections;
import io.ffreedom.polaris.indicators.api.IndicatorCycle;

public class HistoryPriceRecorder {

	private int head = -1;
	private int tail = 0;
	private int count = 0;

	private int capacity;

	private MutableDoubleList priceList;

	private boolean isFull;

	private HistoryPriceRecorder(int capacity) {
		this.capacity = capacity;
		this.priceList = ECollections.newDoubleArrayList(capacity);
	}

	public static HistoryPriceRecorder newRecorder(IndicatorCycle cycle) {
		return new HistoryPriceRecorder(cycle.getValue());
	}

	public boolean isFull() {
		return isFull;
	}

	public double sum() {
		return priceList.sum();
	}

	public double max() {
		return priceList.max();
	}

	public double min() {
		return priceList.min();
	}

	public double average() {
		return priceList.average();
	}

	public double median() {
		return priceList.median();
	}

	public ImmutableDoubleList toImmutable() {
		return priceList.toImmutable();
	}

	public int getCount() {
		return count;
	}

	public HistoryPriceRecorder addTail(double value) {
		updateTailIndex();
		updateHeadIndex();
		updateCount();
		updateTail(value);
		return this;
	}

	private void updateTailIndex() {
		if (++tail == capacity)
			tail = 0;
	}

	private void updateHeadIndex() {
		if (count < capacity)
			return;
		if (++head == capacity)
			head = 0;
	}

	private void updateCount() {
		if (!isFull) {
			if (count == capacity) {
				isFull = true;
				return;
			}
			count++;
		}
	}

	private void updateTail(double value) {
		if (isFull)
			priceList.set(tail, value);
		else
			priceList.add(value);
	}

	public static void main(String[] args) {

		HistoryPriceRecorder recorder = newRecorder(IndicatorCycle.with(10));

		for (int i = 1; i < 30; i++) {
			recorder.addTail(i);
			System.out.println("Count -> " + recorder.count);
			System.out.print("Value -> ");
			recorder.priceList.each(value -> System.out.print(value + " , "));
			System.out.println();
		}

	}

}
