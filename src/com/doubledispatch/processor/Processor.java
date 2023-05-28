package com.doubledispatch.processor;

import com.doubledispatch.cell.*;

/* 
 * All objects must be handled by the default action generalCase except some pairs. 
 * For those pairs some of the following methods must be overridden. 
 * */
public class Processor implements IProcessor<String> {
	// Special process of the certain pair of objects (RedCell + RedCell)
	public String get(RedCell<String> a, RedCell<String> b) {
		return "Special: red hates red";
	}

	public String get(RedCell<String> a, BlueCell<String> b) {
		return generalCase(a, b);
	}

	public String get(RedCell<String> a, GreenCell<String> b) {
		return generalCase(a, b);
	}

	public String get(BlueCell<String> a, RedCell<String> b) {
		return generalCase(a, b);
	}

	public String get(BlueCell<String> a, BlueCell<String> b) {
		return generalCase(a, b);
	}

	public String get(BlueCell<String> a, GreenCell<String> b) {
		return generalCase(a, b);
	}

	public String get(GreenCell<String> a, RedCell<String> b) {
		return generalCase(a, b);
	}

	// Special process of the certain pair of objects (GreenCell + BlueCell)
	public String get(GreenCell<String> a, BlueCell<String> b) {
		return "Special: green loves blue";
	}

	public String get(GreenCell<String> a, GreenCell<String> b) {
		return generalCase(a, b);
	}

	// General process of any other pair of objects
	private String generalCase(ICell<String> a, ICell<String> b) {
		return a.getColor() + "->" + b.getColor();
	}
}
