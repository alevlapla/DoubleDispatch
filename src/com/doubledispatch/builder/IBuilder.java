package com.doubledispatch.builder;

import java.util.function.*;
import com.doubledispatch.cell.*;

/**
 * The interface supports the builder design pattern providing methods to set up
 * representation of the concrete {@link PrototypeDispatcher} object. Methods
 * are used to override the default representation of the concrete
 * {@link PrototypeDispatcher} object (overriding the encapsulated
 * {@link BiFunction}s).
 * 
 * @param <E> a data type of an {@link ICell} object.
 * @param <T> an object implementing the {@link ICell} interface.
 * @param <R> a data type, returned by a visitor object as a result of visiting
 *            an {@link ICell} object.
 */
public interface IBuilder<E, T extends ICell<E>, R> {
	PrototypeDispatcher<E, R> withRed(BiFunction<T, RedCell<E>, R> toDo);

	PrototypeDispatcher<E, R> withBlue(BiFunction<T, BlueCell<E>, R> toDo);

	PrototypeDispatcher<E, R> withGreen(BiFunction<T, GreenCell<E>, R> toDo);
}