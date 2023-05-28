package com.doubledispatch.visitor;

import com.doubledispatch.cell.*;

/**
 * The interface provides the possibility to make polymorphic selection of one
 * of the overloaded {@link #visit()} methods basing on the dynamic type of the
 * enclosing caller object ({@code this}).
 * <p>
 * The interface has the following realizations:<br>
 * - {@link BaseCellVisitor} provides the first step of double dispatch
 * (returning one of the concrete colored {@code CellVisitor}'s,<br>
 * - {@link RedCellVisitor}, {@link BlueCellVisitor} and
 * {@link GreenCellVisitor} provide the second step of double dispatch.<br>
 * 
 * @param <T> a data type of an {@link ICell} object.
 */
public interface ICellVisitor<T> {
	T visit(RedCell cell);

	T visit(BlueCell cell);

	T visit(GreenCell cell);
}