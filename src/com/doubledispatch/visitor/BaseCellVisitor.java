package com.doubledispatch.visitor;

import com.doubledispatch.cell.*;

/**
 * The class provides the realization of the first step of double dispatch. The
 * next visitor is created and returned based on polymorphic selection of one of
 * the overloaded {@code visit()} methods.
 */
public class BaseCellVisitor implements ICellVisitor<ICellVisitor<String>> {
	public RedCellVisitor visit(RedCell cell) {
		return new RedCellVisitor(cell);
	}

	public BlueCellVisitor visit(BlueCell cell) {
		return new BlueCellVisitor(cell);
	}

	public GreenCellVisitor visit(GreenCell cell) {
		return new GreenCellVisitor(cell);
	}
}
