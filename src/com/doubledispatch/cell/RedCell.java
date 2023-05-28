package com.doubledispatch.cell;

import com.doubledispatch.visitor.*;
import com.doubledispatch.processor.*;

/**
 * The concrete colored cell class.
 *
 * @param <T> a data type of an {@code RedCell} object.
 */
public class RedCell<T> implements ICell<T>, ICellVisitor<T> {
	// Object used for double dispatch
	private IProcessor<T> processor;

	public RedCell(IProcessor<T> processor) {
		this.processor = processor;
	}

	@Override
	public String getColor() {
		return "red";
	}

	@Override
	public T accept(ICellVisitor<T> visitor) {
		return visitor.visit(this);
	}

	// Overloaded methods .visit() support the second step of double dispatch
	@Override
	public T visit(RedCell<T> cell) {
		return processor.get(cell, this);
	}

	@Override
	public T visit(BlueCell<T> cell) {
		return processor.get(cell, this);
	}

	@Override
	public T visit(GreenCell<T> cell) {
		return processor.get(cell, this);
	}
}