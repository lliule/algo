package com.algol.array;

/**
 * 实现自己的数组类，封装java 的数组
 * @author leliu
 */
public class Array<T> {

	private T[] data;
	private int size;

	/**
	 * 指定容量构建数组
	 * @param capacity 容量
	 */
	public Array(int capacity) {
		data = (T[])new Object[capacity];
		this.size = 0;
	}

	/**
	 * 无参构建，默认为10
	 */
	public Array() {
		this(10);
	}


	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return data.length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 向数组最后添加一个元素
	 */
	public void addLast(T e) {
		add(size, e);
	}

	/**
	 * 向数组头添加一个元素
	 * @param e e
	 */
	public void addFirst(T e) {
		add(0, e);
	}

	/**
	 * 在 index 位置插入元素 e
	 * @param index 位置
	 * @param e 元素
	 */
	public void add(int index, T e) {
		if(size == data.length) {
			throw new IllegalArgumentException("添加元素失败，数据已经没有空间");
		}

		if(index < 0 || index > size) {
			throw new IllegalArgumentException("添加元素失败，index >= 0  && index <" + size);
		}

		// 将 指定位置之后的元素向后移动

		for (int i = size - 1; i >= index ; i--) {
			data[i+1] = data[i];
		}
		/*
		 * 上面for 循环可以使用
		 * System.arraycopy(data, index, data, index + 1, size - index);
		 * 代替；
		 * 方法参数：
		 * src : 数据源
		 * srcPos: 数据源起始位置
		 * dest: 目标源
		 * destPos: 目标源位置
		 * length： 拷贝长度 size - index 表示从指定的index拷贝到size位置
		 */

		data[index] = e;
		size ++ ;

	}


	public T remove(int index) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("删除元素失败，index >= 0  && index <" + size);
		}
		T ret = data[index];
		for (int i = index; i < size; i++) {
			data[i] = data[i + 1];
		}
		data[size] = null;
		size -- ;
		return ret;
	}

	public T removeLast(){
		return remove(size - 1);
	}

	public T removeFirst(){
		return remove(0);
	}

	public void removeElement(T e) {
		int index = find(e);
		if(index != -1) {
			remove(index);
		}
	}

	private int find(T e) {
		for (int i = 0; i < size; i++) {
			if(data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	public T get(int index) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("参数异常!");
		}
		return data[index];
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("Array: size = %d, capacity = %d\t", size, data.length));
		builder.append("[");
		for (int i = 0; i < size; i++) {
			builder.append(data[i]);
			if( i != size - 1) {
				builder.append(", ");
			}
		}
		builder.append("]");
		return builder.toString();
	}


}
