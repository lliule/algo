package com.algol.linked;

/**
 * LinkendList Create on 2019/5/15
 *
 * @author leliu
 */
public class LinkendList<E> {

	private Node<E> head;
	private int size;

	public LinkendList() { }

	private class Node<E>{
		public E e;
		public Node<E> next;

		public Node(E e, Node<E> next) {
			this.e = e;
			this.next = next;
		}

		public Node(E e) {
			this(e, null);
		}

		public String toString() {
			return e.toString();
		}
	}


	public void addFirst(E e){
		head = new Node<>(e, head);
		size++;
	}

	public void addLast(E e){
		if(head == null) {
			addFirst(e);
		} else {
			Node cur = head;
			while (cur.next != null) {
				cur = cur.next;
			}
			cur.next = new Node<>(e);
			size++;
		}
	}

	public void add(int index, E e){
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("index 不合法");
		}

		if(index == 0) {
			addFirst(e);
		}else {
			Node<E> prev = head;
			for (int i = 0; i < index - 1; i++) {
				prev = prev.next;
			}
			prev.next = new Node<>(e, prev.next);
			size++;
		}
	}


	public void removeFirst() {
		head = head.next;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Node<E> node = head; node != null; node = node.next) {
			result.append(node.toString()).append("->");
		}
		result.append("NULL");
		return result.toString();
	}
}
