package asdf.test;

public class Solution1 {

	/**
	 * (删除倒数第N个)Given a linked list, remove the nth node from the end of list
	 * and return its head. Given n will always be valid. Try to do this in one
	 * pass.
	 */
	// 使用一个指针记录倒数第N个即可

	public ListNode removeNthFromEnd(ListNode head, int n) {

		int num = 0;
		ListNode p = head, t = head;

		while (p != null) {
			if (num++ > n) {
				t = t.next;
			}
			p = p.next;
		}
		if (t == head)
			head = head.next;// 头结点
		else
			t.next = t.next.next;// 删除
			
		return head;
	}

	public static void main(String[] args) {
		Solution1 solution = new Solution1();
		ListNode head = new ListNode(1);

		System.out.println(solution.removeNthFromEnd(head, 1));
	}
}
