package com.algol.linked;

/**
 *双向列表
 * @author leliu
 */
public class DoubleLinkedList<E> {

	private Node<E> dummyHead;
	private Node<E> tail;
	private int size;

	private class Node<E> {
		public E e;
		public Node<E> next;

		public Node(E e, Node<E> next) {
			this.e = e;
			this.next = next;
		}

		public Node(E e) {
			this(e, null);
		}

		@Override
		public String toString() {
			return e.toString();
		}
	}

	public DoubleLinkedList() {
		dummyHead = new Node<>(null, null);
		dummyHead.next = tail;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(E e){
		if(isEmpty()){
			tail = new Node<>(e);
			dummyHead.next = tail;
		}else {
			tail.next = new Node<>(e);
			// 将tail指向最后一个元素
			tail = tail.next;
		}
		size ++;
	}

	public E remove(int index){
		// 如果链表是Null
		if(isEmpty() || (index > size || index < 0)) {
			throw new IllegalArgumentException("参数异常");
		}

		Node<E> prev = dummyHead;
		for (int i = 0; i < index ; i++) {
			prev = prev.next;
		}
		Node<E> cur = prev.next;
		prev.next = cur.next;
		cur.next = null;
		size --;
		return cur.e;
	}

	public E removeFirst(){
		return remove(0);
	}

	public E get(){
		if(isEmpty()) {
			return null;
		}
		return tail.e;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Node cur = dummyHead.next;
		while (cur != null) {
			builder.append(cur).append("->");
			cur = cur.next;
		}
		builder.append("NULL");
		return builder.toString();

	}
}
