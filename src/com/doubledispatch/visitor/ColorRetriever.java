package com.doubledispatch.visitor;

import com.doubledispatch.cell.*;

/**
 * The supplementary class used as a visitor object for an object of the
 * {@link ICell} interface. The only action of this visitor is to retrieve a
 * color name from an object of the {@link ICell} interface.
 */
public class ColorRetriever implements ICellVisitor<String> {
	public String visit(RedCell cell) {
		return cell.getColor();
	}

	public String visit(BlueCell cell) {
		return cell.getColor();
	}

	public String visit(GreenCell cell) {
		return cell.getColor();
	}
}
