package com.doubledispatch.visitor;

import com.doubledispatch.cell.*;

public class BlueCellVisitor implements ICellVisitor<String> {
	private BlueCell caller;

	public BlueCellVisitor(BlueCell caller) {
		this.caller = caller;
	}

	public String visit(RedCell cell) {
		return generalCase(cell);
	}

	public String visit(BlueCell cell) {
		return generalCase(cell);
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
