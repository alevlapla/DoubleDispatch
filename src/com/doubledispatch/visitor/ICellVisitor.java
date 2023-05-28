package com.doubledispatch.visitor;

import com.doubledispatch.cell.*;

/**
 * The interface provides the possibility to make polymorphic selection of one
 * of the overloaded {@link #visit()} methods thus determining a type of an
 * argument object.
 * 
 * @param <E> a data type of an {@link ICell} object to be visited.
 * @param <R> a data type, returned by a visitor object as a result of visiting
 *            an {@link ICell} object.
 */
public interface ICellVisitor<E, R> {
	R visit(RedCell<E> cell);

	R visit(BlueCell<E> cell);

	R visit(GreenCell<E> cell);
}
