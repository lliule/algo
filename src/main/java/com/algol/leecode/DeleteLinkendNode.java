package com.algol.leecode;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 *
 * @author leliu
 * @date 2019/5/17 15:50
 */
public class DeleteLinkendNode {

	private ListNode head = new ListNode(1);

	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
    }

	public void add(int val) {
		ListNode cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = new ListNode(val);
	}


	public void remove(int val){
		ListNode prev = head;
		if(head.val == val) {
			head = head.next;
			prev.next = null;
		} else {
			ListNode cur = prev.next;
			while (cur != null) {
				if(cur.val == val){
					prev.next = cur.next;
					cur.next = null;
					break;
				}
				prev = cur;
				cur = cur.next;
			}
		}

	}

	@Override
	public String toString() {
		final String sign = "->";
		StringBuilder builder = new StringBuilder();
		ListNode cur = head;
		while (cur != null) {
			builder.append(cur.val).append(sign);
			cur = cur.next;
		}
		String result = builder.toString();
		return result.substring(0, result.length() - sign.length());
	}

	public static void main(String[] args) {
		DeleteLinkendNode deleteLinkendNode = new DeleteLinkendNode();
		deleteLinkendNode.add(4);
		deleteLinkendNode.add(5);
		deleteLinkendNode.add(6);
		deleteLinkendNode.add(9);
		deleteLinkendNode.remove(5);
		System.out.println(deleteLinkendNode);
	}
}
