package com.doubledispatch.cell;

import com.doubledispatch.visitor.*;

/**
 * The concrete colored cell class.
 *
 * @param <E> a data type of an {@code RedCell} object.
 */
public class RedCell<E> implements ICell<E> {
	@Override
	public String getColor() {
		return "red";
	}

	@Override
	public <R> R accept(ICellVisitor<E, R> visitor) {
		return visitor.visit(this);
	}
}
