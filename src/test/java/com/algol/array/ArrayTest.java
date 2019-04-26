package com.algol.array;

import org.junit.Test;

/**
 *
 * @author leliu
 */
public class ArrayTest {

	@Test
	public void testToString() {
		Array arr = new Array(20);
		for (int i = 0; i < 5; i++) {
			arr.addLast(i);
		}

		arr.add(1, 100);
		arr.addFirst(-1);

		System.out.println(arr);
	}
}
