package com.doubledispatch.builder;

import java.util.function.*;
import com.doubledispatch.cell.*;
import com.doubledispatch.visitor.ICellVisitor;

/**
 * The prototype class for a dispatcher object. The object of this class is used
 * for successive call {@code visit(ICell).visit(ICell)}, thus allowing to
 * double dispatch based on dynamic types of two {@code ICell} objects.
 * <p>
 * The class encapsulates builders for every {@link ICell} color. When a
 * dispatcher object is created, inside of all colored builders the default
 * action {@code generalCase} is encapsulated.
 * <p>
 * Methods {@code takeRed()}, {@code takeBlue()} and {@code takeGreen()} are
 * used to return a corresponding builder for further modification. After
 * calling one of these methods, a builder method {@code withRed()},
 * {@code withBlue()} or {@code withGreen()} must be called for modifying a
 * corresponding builder and representation of a {@link PrototypeDispatcher}
 * object.
 * <p>
 * A dispatcher object is a part of the visitor pattern. This class implements
 * {@link ICellVisitor} interface. Calling its {@code visit()} methods causes
 * the first step of double dispatch to be done. After polymorphic selection of
 * one of the overloaded {@code visit()} methods, the corresponding builder for
 * a colored {@link ICell} object saves the first target object in itself. The
 * saved target object is used during the second step of double dispatch inside
 * of an object of {@link Builder} class.
 *
 * @param <E> a data type of an {@link ICell} object.
 * @param <R> a data type, returned by a visitor object as a result of visiting
 *            an {@link ICell} object.
 */

public class PrototypeDispatcher<E, R> implements ICellVisitor<E, ICellVisitor<E, R>> {
	// Colored builders for setting up representation of a concrete
	// PrototypeDispatcher object. Colored builders are responsible for setting up
	// special behavior of PrototypeDispatcher object depending on types of argument
	// objects.
	private Builder<E, RedCell<E>, R> redBuilder;
	private Builder<E, BlueCell<E>, R> blueBuilder;
	private Builder<E, GreenCell<E>, R> greenBuilder;

	// generalCase is the default BiFunction applied to two objects of any ICell
	// subtypes. When PrototypeDispatcher is created, all its behavior set to
	// generalCase
	/**
	 * Creates a PrototypeDispatcher object providing feature of double dispatch.
	 * Double dispatch is provided by successive call of
	 * {@link PrototypeDispatcher}.{@code visit(}{@link ICell}{@code ).visit(}{@link ICell}{@code )}.
	 * 
	 * @param generalCase the default {@link BiFunction} set for all colored
	 *                    builders.
	 */
	public PrototypeDispatcher(BiFunction<ICell<E>, ICell<E>, R> generalCase) {

		// All builders are set to default action - generalCase
		redBuilder = new Builder<E, RedCell<E>, R>(this, generalCase);
		blueBuilder = new Builder<E, BlueCell<E>, R>(this, generalCase);
		greenBuilder = new Builder<E, GreenCell<E>, R>(this, generalCase);
	}

	/*
	 * Getters of corresponding colored builders. The next method call should be
	 * IBuilder.withRed(BiFunction), .withBlue(BiFunction), .withGreen(BiFunction)
	 * for assigning a PrototypeDispatcher object special handling of certain ICell
	 * objects.
	 */
	public IBuilder<E, RedCell<E>, R> takeRed() {
		return redBuilder;
	}

	public IBuilder<E, BlueCell<E>, R> takeBlue() {
		return blueBuilder;
	}

	public IBuilder<E, GreenCell<E>, R> takeGreen() {
		return greenBuilder;
	}

	/*
	 * Methods provide the first step of double dispatch. After polymorphic
	 * selection of one of the overloaded methods by a type of the first argument
	 * object, this argument object is being recorded to a corresponding colored
	 * builder object.
	 */
	public ICellVisitor<E, R> visit(RedCell<E> cell) {
		return redBuilder.take(cell);
	}

	public ICellVisitor<E, R> visit(BlueCell<E> cell) {
		return blueBuilder.take(cell);
	}

	public ICellVisitor<E, R> visit(GreenCell<E> cell) {
		return greenBuilder.take(cell);
	}
}