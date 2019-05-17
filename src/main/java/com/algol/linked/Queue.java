package com.algol.linked;

/**
 *
 * @author leliu
 */
public interface Queue<E> {
	/**
	 * 弹出第一个元素
	 * @return E
	 */
	E pop();

	/**
	 * 查看第一个元素
	 * @return
	 */
	E pick();

	/**
	 * 删除一个元素
	 * @return
	 */
	E remove();

	/**
	 * 添加一个元素
	 * @param e
	 */
	void add(E e);

}
