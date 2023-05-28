package com.doubledispatch.visitor;

import com.doubledispatch.cell.*;

/**
 * The interface provides the first step of double dispatch based on dynamic
 * types of two objects. Polymorphic selection of one of the overloaded
 * {@code visit()} methods is based on the dynamic type of the enclosing caller
 * object (the passed argument {@code cell} to {@code visit()} methods is
 * {@code this}).
 * 
 * @param <T> a data type of an {@link ICell} object to be visited.
 */
public interface ICellVisitor<T> {
	T visit(RedCell<T> cell);

	T visit(BlueCell<T> cell);

	T visit(GreenCell<T> cell);
}
