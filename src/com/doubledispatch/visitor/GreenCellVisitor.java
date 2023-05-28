package com.doubledispatch.visitor;

import com.doubledispatch.cell.*;

public class GreenCellVisitor implements ICellVisitor<String> {
	private GreenCell caller;

	public GreenCellVisitor(GreenCell caller) {
		this.caller = caller;
	}

	public String visit(RedCell cell) {
		return generalCase(cell);
	}

	// Special process of the certain pair of objects (GreenCell + BlueCell)
	public String visit(BlueCell cell) {
		return "Special: green loves blue";
	}

	public String visit(GreenCell cell) {
		return generalCase(cell);
	}

	// General process of any other pair of objects
	private String generalCase(ICell<String> cell) {
		ColorRetriever cr = new ColorRetriever();
		String aCell = caller.accept(cr);
		String bCell = caller.accept(cr);
		return aCell + "->" + bCell;
	}
}
