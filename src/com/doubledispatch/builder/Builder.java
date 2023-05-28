package com.doubledispatch.builder;

import java.util.function.*;
import com.doubledispatch.cell.*;
import com.doubledispatch.visitor.*;

/**
 * The class realizes the builder design pattern providing methods for setting
 * up representation of a {@link PrototypeDispatcher} object, thus allowing
 * special handling of objects of certain {@link ICell} subtypes.
 * 
 * @param <E> a data type of an {@link ICell} object.
 * @param <T> an object implementing {@link ICell} interface.
 * @param <R> a data type, returned by a visitor object as a result of visiting
 *            an {@link ICell} object.
 */
public class Builder<E, T extends ICell<E>, R> implements IBuilder<E, T, R>, ICellVisitor<E, R> {

	/**
	 * The enclosing {@link PrototypeDispatcher} object. A builder sets up its
	 * representation by methods {@link #withRed(BiFunction)},
	 * {@link #withBlue(BiFunction)}, {@link #withGreen(BiFunction)}.
	 */
	private PrototypeDispatcher<E, R> dispatcher;

	/**
	 * The default {@link BiFunction} set for all colored builders.
	 */
	private BiFunction<ICell<E>, ICell<E>, R> generalCase;

	// Overridden BiFunctions for certain types of colored ICell objects. Overriding
	// is done by methods .withRed(BiFunction), .withBlue(BiFunction),
	// .withGreen(BiFunction). By default all set to default action - generalCase
	private BiFunction<T, RedCell<E>, R> takeRed;
	private BiFunction<T, BlueCell<E>, R> takeBlue;
	private BiFunction<T, GreenCell<E>, R> takeGreen;

	/**
	 * The first visited argument object. The first step of double dispatch
	 * dependent on its type.
	 */
	private T target;

	public Builder(PrototypeDispatcher<E, R> dispatcher, BiFunction<ICell<E>, ICell<E>, R> generalCase) {
		this.dispatcher = dispatcher;
		this.generalCase = generalCase;
		// All builders are set to the default action - generalCase
		takeRed = (a, b) -> generalCase.apply(a, b);
		takeBlue = (a, b) -> generalCase.apply(a, b);
		takeGreen = (a, b) -> generalCase.apply(a, b);
	}

	public PrototypeDispatcher<E, R> withRed(BiFunction<T, RedCell<E>, R> toDo) {
		takeRed = toDo;
		return dispatcher;
	}

	public PrototypeDispatcher<E, R> withBlue(BiFunction<T, BlueCell<E>, R> toDo) {
		takeBlue = toDo;
		return dispatcher;
	}

	public PrototypeDispatcher<E, R> withGreen(BiFunction<T, GreenCell<E>, R> toDo) {
		takeGreen = toDo;
		return dispatcher;
	}

	/*
	 * The set of overloaded methods for polymorphic choose. Methods provide the
	 * second step of double dispatch. Having the static type of the second argument
	 * object, finally it is possible to select a certain BiFunction depending on
	 * certain dynamic types of argument objects, calling .apply() for the final
	 * process.
	 */
	@Override
	public R visit(RedCell<E> cell) {
		return takeRed.apply(target, cell);
	}

	@Override
	public R visit(BlueCell<E> cell) {
		return takeBlue.apply(target, cell);
	}

	@Override
	public R visit(GreenCell<E> cell) {
		return takeGreen.apply(target, cell);
	}

	/**
	 * Saves the first argument object processed by a current
	 * {@link PrototypeDispatcher} object.
	 * 
	 * @param a the first object to be used in double dispatch.
	 * @return {@link ICellVisitor} object used in the second step of double
	 *         dispatch.
	 */
	public ICellVisitor<E, R> take(T a) {
		target = a;
		return this;
	}
}