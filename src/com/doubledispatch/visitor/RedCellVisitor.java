package com.doubledispatch.visitor;

import com.doubledispatch.cell.*;

public class RedCellVisitor implements ICellVisitor<String> {
	private RedCell caller;

	public RedCellVisitor(RedCell caller) {
		this.caller = caller;
	}

	// Special process of the certain pair of objects (RedCell + RedCell)
	public String visit(RedCell cell) {
		return "Special: red loves red";
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
