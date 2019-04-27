package com.algol.array;

import org.junit.Test;

/**
 *
 * @author leliu
 */
public class ArrayTest {

	@Test
	public void testToString() {
		Array<Integer> arr = new Array<>();
		for (int i = 0; i < 10; i++) {
			arr.addLast(i);
		}
		System.out.println(arr);

		arr.add(1, 100);
		System.out.println(arr);

		arr.removeLast();
		System.out.println(arr);

	}


	@Test
	public void test2() {
		Array<Student> array = new Array<>();
		array.addLast(new Student("ali", 50));
		array.addLast(new Student("dana", 80));
		array.addLast(new Student("vic", 90));
		System.out.println(array);
	}
}
