package com.algol.linked;

/**
 * 链表队列，
 * 先进先出。添加的元素在链表首位置，删除的元素从链表尾位置
 * @author leliu
 */
public class LinkedListQueue<E>  implements Queue<E> {

	private DoubleLinkedList<E> linkedList = new DoubleLinkedList<>();


	@Override
	public E pop() {
		return linkedList.removeFirst();
	}

	@Override
	public E pick() {
		return linkedList.get();
	}

	@Override
	public E remove() {
		return linkedList.removeFirst();
	}

	@Override
	public void add(E e) {
		linkedList.add(e);
	}

	@Override
	public String toString() {
		return "head [" + linkedList + "]tail";
	}
}
