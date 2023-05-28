package com.doubledispatch.cell;

import com.doubledispatch.visitor.*;

/**
 * The interface supports the visitor design pattern providing a method to
 * accept a visitor object.
 * 
 * @param <E> a data type of an {@link ICell} object.
 */
public interface ICell<E> {
	/**
	 * Retrieves a color name encapsulated in an object of the {@link ICell}
	 * interface.
	 * 
	 * @return a color name as a {@link String}.
	 */
	String getColor();

	/**
	 * Accepts a visitor object of the type {@link ICellVisitor}.
	 * 
	 * @param visitor a visitor object of type {@link ICellVisitor}.
	 * @return result of double dispatch.
	 * @param <R> a data type, returned by a visitor object as a result of visiting
	 *            an {@link ICell} object.
	 */
	<R> R accept(ICellVisitor<E, R> visitor);
}
