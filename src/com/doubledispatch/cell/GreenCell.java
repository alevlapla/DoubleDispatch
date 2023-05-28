package com.doubledispatch.cell;

import com.doubledispatch.visitor.*;

/**
 * The concrete colored cell class.
 */
public class GreenCell implements ICell<String> {
	public String getColor() {
		return "green";
	}

	public String accept(ICellVisitor<String> visitor) {
		return visitor.visit(this);
	}
}
