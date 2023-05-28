package com.doubledispatch.processor;

import com.doubledispatch.cell.*;

/**
 * The interface provides the second step of double dispatch based on dynamic
 * types of two objects. Polymorphic selection of one of the overloaded {@code .get()}
 * methods is based on received:<br>
 * - a static type from one of the {@link ICellVisitor}
 * overloaded {@code visit()} methods,<br>
 * - a dynamic type of the enclosing caller object ({@code this}).
 * 
 *  @param <T> a data type of an {@link ICell} objects to be processed.
 */
public interface IProcessor<T> {
	T get(RedCell<T> a, RedCell<T> b);

	T get(RedCell<T> a, BlueCell<T> b);

	T get(RedCell<T> a, GreenCell<T> b);

	T get(BlueCell<T> a, RedCell<T> b);

	T get(BlueCell<T> a, BlueCell<T> b);

	T get(BlueCell<T> a, GreenCell<T> b);

	T get(GreenCell<T> a, RedCell<T> b);

	T get(GreenCell<T> a, BlueCell<T> b);

	T get(GreenCell<T> a, GreenCell<T> b);
}
