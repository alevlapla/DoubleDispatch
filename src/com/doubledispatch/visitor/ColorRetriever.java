package com.doubledispatch.visitor;

import com.doubledispatch.cell.*;

/**
 * The supplementary class used as a visitor object for an object of the
 * {@link ICell} interface. The only action of this visitor is to retrieve a
 * color name from an object of the {@link ICell} interface.
 *
 * @param <E> a data type of an {@link ICell} object.
 */
public class ColorRetriever<E> implements ICellVisitor<E, String> {
	public String visit(RedCell<E> cell) {
		return cell.getColor();
	}

	public String visit(BlueCell<E> cell) {
		return cell.getColor();
	}

	public String visit(GreenCell<E> cell) {
		return cell.getColor();
	}
}
