package com.doubledispatch.cell;

import com.doubledispatch.visitor.*;

/**
 * The interface supports the visitor design pattern providing a method to
 * accept a visitor objectT
 * 
 * @param <T> a data type of an {@link ICell} object.
 */
public interface ICell<T> {
	String getColor();

	/**
	 * Accepts a visitor object for further double dispatch.
	 * 
	 * @param visitor a visitor object.
	 * @return result of double dispatch.
	 */
	T accept(ICellVisitor<T> visitor);
}