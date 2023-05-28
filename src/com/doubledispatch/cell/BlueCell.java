package com.doubledispatch.cell;

import com.doubledispatch.visitor.*;

/**
 * The concrete colored cell class.
 *
 * @param <E> a data type of an {@code BlueCell} object.
 */
public class BlueCell<T> implements ICell<T> {
	@Override
	public String getColor() {
		return "blue";
	}

	@Override
	public <R> R accept(ICellVisitor<T, R> visitor) {
		return visitor.visit(this);
	}
}
