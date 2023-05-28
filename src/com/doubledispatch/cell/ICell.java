package com.doubledispatch.cell;

import com.doubledispatch.visitor.*;

/**
 * The interface supports the visitor design pattern providing a method to
 * accept a visitor object.
 * 
 * @param <T> a data type of an {@link ICell} object.
 */
public interface ICell<T> {
	/**
	 * Retrieves a color name encapsulated in an object of the {@link ICell}
	 * interface.
	 * 
	 * @return a color name as a {@link String}.
	 */
	String getColor();

	/**
	 * Accepts a visitor object for further double dispatch.
	 * 
	 * @param visitor a visitor object of type {@link ICellVisitor}.
	 * @return result of double dispatch.
	 */
	T accept(ICellVisitor<T> visitor);
}
