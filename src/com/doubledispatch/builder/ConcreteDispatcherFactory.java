package com.doubledispatch.builder;

import com.doubledispatch.cell.*;
import com.doubledispatch.visitor.*;

/**
 * The utility class responsible for:<br>
 * - creation of a {@link PrototypeDispatcher} object,<br>
 * - setting up its representation, thus allowing special handling for desired
 * combination of {@link ICell} argument object types.
 * <p>
 * A {@link PrototypeDispatcher} object with set representation enables double
 * dispatch to be done, thus implementing a final action depending on dynamic
 * types of two {@link ICell} argument objects.
 * 
 * @param <E> a data type of an {@link ICell} object.
 */
public class ConcreteDispatcherFactory<E> {

	/**
	 * A factory method creating a {@link PrototypeDispatcher} object. The created
	 * object is responsible for providing the possibility of special handling
	 * depending on dynamic types of {@link ICell} argument objects. This special
	 * handling if being set by means of encapsulated colored {@link Builder}
	 * objects. For changing this special handling, a colored {@link Builder} must
	 * be taken (methods {@link PrototypeDispatcher}{@code .takeRed()},
	 * {@code .takeBlue()}, {@code .takeGreen()}), then one of a builder's methods
	 * is called ({@link IBuilder}{@code .withRed(BiFunction)},
	 * {@code .withBlue(BiFunction)}, {@code .withGreen(BiFunction)}) for changing
	 * representation of {@link PrototypeDispatcher} object.
	 * 
	 * @return base {@link ICellVisitor} object for the first step of double
	 *         dispatch.
	 */
	public ICellVisitor<E, ICellVisitor<E, String>> createDispatcher() {

		ICellVisitor<E, ICellVisitor<E, String>> icv = new PrototypeDispatcher<E, String>(
				// Default action for any pair of ICell objects.
				ConcreteDispatcherFactory::process)
				// Setting special handling for a pair of ICell objects: RedCell + RedCell
				// (redBuilder from a PrototypeDispatcher object are taken, then desired
				// BiFunction is encapsulated into redBuilder as a method reference to a static
				// method)
				.takeRed().withRed(ConcreteDispatcherFactory::process)
				// Setting special handling for a pair of ICell objects: GreenCell + BlueCell
				.takeGreen().withBlue(ConcreteDispatcherFactory::process);
		return icv;
	}

	/**
	 * The method of default handling of objects of any {@link ICell} subtypes.
	 * 
	 * @param <E> a data type of an object of the {@link ICell} interface.
	 * @param a   an {@link ICell} object to be handled by the default action of
	 *            {@link PrototypeDispatcher} object.
	 * @param b   an {@link ICell} object to be handled by the default action of
	 *            {@link PrototypeDispatcher} object.
	 * @return a {@link String} as a result of the default handling of double
	 *         dispatch.
	 */
	private static <E> String process(ICell<E> a, ICell<E> b) {
		// The default action is: to visit both objects and retrieve its colors.
		ColorRetriever<E> colorRetriever = new ColorRetriever<>();
		String aColor = a.accept(colorRetriever);
		String bColor = b.accept(colorRetriever);
		return aColor + "->" + bColor;
	}

	/**
	 * The method of special handling of objects of certain {@link ICell} subtypes:
	 * {@link GreenCell} and {@link BlueCell}.
	 * 
	 * @param <E> a data type of an object of the {@link ICell} interface.
	 * @param a   a {@link GreenCell} object taken into account, when choosing the
	 *            final action of a {@link PrototypeDispatcher} object.
	 * @param b   a {@link BlueCell} object taken into account, when choosing the
	 *            final action of a {@link PrototypeDispatcher} object.
	 * @return a {@link String} as a result of special handling of double dispatch.
	 */
	private static <E> String process(GreenCell<E> a, BlueCell<E> b) {
		return "Special handling of types: GreenCell + BlueCell";
	}

	/**
	 * The method of special handling of objects of certain {@link ICell} subtypes:
	 * {@link RedCell} and {@link RedCell}.
	 * 
	 * @param <E> a data type of an object of the {@link ICell} interface.
	 * @param a   a {@link RedCell} object taken into account, when choosing the
	 *            final action of a {@link PrototypeDispatcher} object.
	 * @param b   a {@link RedCell} object taken into account, when choosing the
	 *            final action of a {@link PrototypeDispatcher} object.
	 * @return a {@link String} as a result of special handling of double dispatch.
	 */
	private static <E> String process(RedCell<E> a, RedCell<E> b) {
		return "Special handling of types: RedCell + RedCell";
	}
}