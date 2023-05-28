package com.doubledispatch.main;

import com.doubledispatch.cell.*;
import com.doubledispatch.visitor.*;

/**
 * The example demonstrates double dispatch done by means of the successive
 * calls of
 * {@link BaseCellVisitor}{@code .visit(}{@link ICell}{@code )}{@code .visit(}{@link ICell}{@code )}.
 * <p>
 * Double dispatch is done by two steps:<br>
 * - the first step is a call of one of
 * {@link BaseCellVisitor}{@code .visit(}{@link ICell}{@code )} overloaded
 * methods. It returns a corresponding colored {@code CellVisitor} depending on
 * a type of the first argument object.<br>
 * - the second step is a call of one of a returned colored
 * {@code CellVisitor}{@code .visit(}{@link ICell}{@code )} overloaded methods.
 * <p>
 * Thus, selection of one of colored
 * {@code CellVisitor}{@code .visit(}{@link ICell}{@code )} overloaded methods
 * is dependent on types of two argument objects.
 * 
 * <p>
 * The supplementary {@link ColorRetriever} class used as a visitor object to
 * get data from {@link ICell} objects.
 *
 * @author Johanan <a href="https://habr.com/ru/users/Johanan/">habr.com user
 *         profile</a>
 * @author bratishka (only elaborating comments and trying to understand...)
 * @see <a href="https://habr.com/ru/articles/259031/">Двойная
 *      диспетчеризация</a> (Double dispatch)
 */
public class Main {
	public static void main(String[] args) {
		RedCell red = new RedCell();
		BlueCell blue = new BlueCell();
		GreenCell green = new GreenCell();
		BaseCellVisitor bcv = new BaseCellVisitor();

		// Successive calls bring the desired result
		System.out.println(bcv.visit(red).visit(green));
		System.out.println(bcv.visit(red).visit(red));
		System.out.println(bcv.visit(green).visit(blue));
	}
}