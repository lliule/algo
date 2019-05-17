package com.algol.linked;

import org.junit.Test;

/**
 * LinkendTest Create on 2019/5/15
 *
 * @author leliu
 */
public class LinkendTest {

	@Test
	public void test() {
		LinkendList<Integer> list = new LinkendList<>();
		for (int i = 0; i < 5; i++) {
			list.addFirst(i);
		}

		for (int i = 5; i > 0; i--) {
			list.addLast(i);
		}
		list.add(2, 666);
		System.out.println(list);
		System.out.println(list.getSize());
	}



	@Test
	public void test2() {
		LinkedListQueue<Integer> queue = new LinkedListQueue<>();
		for (int i = 1; i < 10; i++) {
			queue.add(i);
			System.out.println(queue);
			if(i % 3 == 0) {
				queue.remove();
				System.out.println(queue);
			}
		}
		System.out.println(queue);

	}
}
