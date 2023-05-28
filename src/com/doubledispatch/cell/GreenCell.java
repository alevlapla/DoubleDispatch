package com.doubledispatch.cell;

import com.doubledispatch.visitor.*;

/**
 * The concrete colored cell class.
 *
 * @param <E> a data type of an {@code GreenCell} object.
 */
public class GreenCell<T> implements ICell<T> {
	@Override
	public String getColor() {
		return "green";
	}

	@Override
	public <R> R accept(ICellVisitor<T, R> visitor) {
		return visitor.visit(this);
	}
}
