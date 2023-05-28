package com.doubledispatch.cell;

import com.doubledispatch.visitor.*;

/**
 * The concrete colored cell class.
 */
public class RedCell implements ICell<String> {
	public String getColor() {
		return "red";
	}

	public String accept(ICellVisitor<String> visitor) {
		return visitor.visit(this);
	}
}
