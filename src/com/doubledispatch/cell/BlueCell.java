package com.doubledispatch.cell;

import com.doubledispatch.visitor.*;

/**
 * The concrete colored cell class.
 */
public class BlueCell implements ICell<String> {
	public String getColor() {
		return "blue";
	}

	public String accept(ICellVisitor<String> visitor) {
		return visitor.visit(this);
	}
}
