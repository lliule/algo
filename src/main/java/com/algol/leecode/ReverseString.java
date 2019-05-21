package com.algol.leecode;

/**
 *https://leetcode-cn.com/problems/reverse-string/
 * @author leliu
 */
public class ReverseString {

	// h e l l o
	public void reverseString(char[] s) {
		for (int i = 0; i < s.length / 2; i++) {
			char temp = s[i];
			s[i] = s[s.length - 1 - i];
			s[s.length - 1 - i] = temp;
		}
		System.out.println(new String(s));
	}

	public static void main(String[] args) {
		new ReverseString().reverseString("hello1".toCharArray());
	}
}
