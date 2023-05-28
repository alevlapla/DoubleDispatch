package com.doubledispatch.main;

import com.doubledispatch.cell.*;
import com.doubledispatch.processor.*;

/**
 * The example demonstrates double dispatch done by means of the following:<br>
 * - each {@link ICell} object is an object to be visited and a visitor at the
 * same time,<br>
 * - a {@link Processor} object contains set of overloaded {@code process(ICell, ICell)}
 * methods of all possible pairs of {@link ICell} objects.
 * <p>
 * The double dispatch example is based on the visitor design pattern.
 * 
 * @author Johanan <a href="https://habr.com/ru/users/Johanan/">habr.com user
 *         profile</a>
 * @author bratishka (only elaborating comments and trying to understand...)
 * @see <a href="https://habr.com/ru/articles/259031/">Двойная
 *      диспетчеризация</a> (Double dispatch)
 */
public class Main {
	public static void main(String[] args) {
		Processor processor = new Processor();
		ICell<String> red = new RedCell<>(processor);
		ICell<String> blue = new BlueCell<>(processor);
		ICell<String> green = new GreenCell<>(processor);

		// A cell is visited by another cell rather then separate visitor object
		System.out.println(red.accept(new GreenCell<>(processor)));
		System.out.println(red.accept(new RedCell<>(processor)));
		System.out.println(green.accept(new BlueCell<>(processor)));
	}
}