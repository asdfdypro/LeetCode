package asdf.test;

public class Solution {

	/**
	 * (删除倒数第N个)Given a linked list, remove the nth node from the end of list
	 * and return its head. Given n will always be valid. Try to do this in one
	 * pass.
	 */
//使用N长度数组记录最后N个
	
	public ListNode removeNthFromEnd(ListNode head, int n) {

		int num = n + 1;
		ListNode temp[] = new ListNode[num];
		int t = 0;
		ListNode p = head;

		while (p != null) {
			temp[t++ % num] = p;
			p = p.next;
		}
		if (temp[t % num] == null)
			head = head.next;// 头结点
		else
			temp[t % num].next = temp[(t + 1) % num].next;// 删除

		return head;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);

		System.out.println(solution.removeNthFromEnd(head, 1));
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
