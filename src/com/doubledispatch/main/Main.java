package com.doubledispatch.main;

import com.doubledispatch.builder.*;
import com.doubledispatch.cell.*;
import com.doubledispatch.visitor.*;

/**
 * The example demonstrates double dispatch done by means of:<br>
 * - a {@link PrototypeDispatcher} object and <br>
 * - successive calls of
 * {@link PrototypeDispatcher}{@code .visit(}{@link ICell}{@code ).visit(}{@link ICell}{@code )}.<br>
 * Thus, a {@link PrototypeDispatcher} object implements an action depending on
 * two dynamic types of argument objects.
 * <p>
 * The double dispatch example is based on the following design
 * patterns:<br>
 * - the visitor design pattern - is used to visit a target object during
 * different steps of double dispatch,<br>
 * - the builder design pattern - is used to build up representation of a
 * {@link PrototypeDispatcher} object.
 * <p>
 * A {@link PrototypeDispatcher} object's action depends on its representation.
 * The representation of {@link PrototypeDispatcher} object is set by
 * corresponding and encapsulated colored {@link IBuilder} objects.
 * <p>
 * Representation of a {@link PrototypeDispatcher} object consists of the
 * default action applied to any objects of the {@link ICell} interface. Change
 * of representation could be done, thus allowing special handling of certain
 * {@link ICell} subtype pairs by means of {@link PrototypeDispatcher} and
 * {@link IBuilder} methods.
 * <p>
 * Actions (default and those dependent on types of argument objects) are
 * {@code BiFunction} objects. These action-objects are encapsulated in colored
 * {@code IBuilder} objects inside of a {@link PrototypeDispatcher} object as
 * method reference to a static method.
 * <p>
 * For example, the {@link PrototypeDispatcher} object's default action is
 * applied for any pair of {@link ICell} objects, but for pairs:<br>
 * - {@link RedCell} and {@link RedCell},<br>
 * - {@link GreenCell} and {@link BlueCell}<br>
 * special action (special handling) must be done.
 * <p>
 * As a convenience a factory {@link ConcreteDispatcherFactory} for creation a
 * {@link PrototypeDispatcher} object can be used.
 * 
 * @author Johanan <a href="https://habr.com/ru/users/Johanan/">habr.com user
 *         profile</a>
 * @author bratishka (only elaborating comments and trying to understand...)
 * @see <a href="https://habr.com/ru/articles/259031/">Двойная
 *      диспетчеризация</a> (Double dispatch)
 */
public class Main {
	public static void main(String[] args) {
		RedCell<String> red = new RedCell<>();
		BlueCell<String> blue = new BlueCell<>();
		GreenCell<String> green = new GreenCell<>();

		ConcreteDispatcherFactory<String> cdf = new ConcreteDispatcherFactory<>();
		// Dispatcher object for double dispatch.
		ICellVisitor<String, ICellVisitor<String, String>> dispatcher = cdf.createDispatcher();
		
		// Double dispatch is done:
		// Default action (handling)
		System.out.println(dispatcher.visit(red).visit(green));
		// Special action (handling)
		System.out.println(dispatcher.visit(red).visit(red));
		System.out.println(dispatcher.visit(green).visit(blue));
	}
}
