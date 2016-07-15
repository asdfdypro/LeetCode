package asdf.test;

public class Solution {

	/**
	 * (右移列表)Given a list, rotate the list to the right by k places, where k is
	 * non-negative.
	 * 
	 * For example:
	 * 
	 * Given 1->2->3->4->5->NULL and k = 2,
	 * 
	 * return 4->5->1->2->3->NULL.
	 */
	// 考虑到右移次数可能很多
	// 1、先统计总长度，再算出截断位置
	// 2、q,p指针距离k，p指针遍历，到尾部部后将链表变为环，当p,q间距为k后，p再次到尾部，q为阶段点
	// 方案2可能循环很多次，实现方案1
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0)
			return head;

		// 计数
		int n = 1;
		ListNode p = head;
		while (p.next != null) {
			p = p.next;
			n++;
		}

		int pos = n - k % n;
		if (pos == n)
			return head;

		ListNode q = head;
		n = 1;
		while (n < pos) {
			q = q.next;
			n++;
		}

		p.next = head;
		head = q.next;
		q.next = null;

		return head;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		for (int i = 0; i < 10; i++) {

			ListNode head
//			 =null
			= new ListNode(1);
			head
//			.setNext(new ListNode(2)).setNext(new ListNode(3)).setNext(new ListNode(4))
					.setNext(new ListNode(5))
			 ;

			ListNode res = solution.rotateRight(head, i);
			while (res != null) {
				System.out.print(res.val + "--");
				res = res.next;
			}
			System.out.println();

		}

	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public ListNode setNext(ListNode next) {
		this.next = next;
		return next;
	}
}