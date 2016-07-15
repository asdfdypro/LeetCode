package asdf.test;

public class Test {
	public static void printList(ListNode l) {
		while (l != null) {
			System.out.print(l.val);
			System.out.print("-->");
			l = l.next;
		}
		System.out.println();
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = null, p = null;
		int c = 0;
		while (l1 != null || l2 != null) {
			if (l1 != null)
				c += l1.val;
			if (l2 != null)
				c += l2.val;
			if (res == null) {
				res = new ListNode(c % 10);
				p = res;
			} else {
				p.next = new ListNode(c % 10);
				p = p.next;
			}
			c = c / 10;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (c != 0) {
			if (res == null) {
				res = new ListNode(c);
			} else {
				p.next = new ListNode(c);
			}
		}
		return res;
	}

	/**
	 * You are given two linked lists representing two non-negative numbers. The
	 * digits are stored in reverse order and each of their nodes contain a
	 * single digit. Add the two numbers and return it as a linked list. Input:
	 * (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		ListNode l11 = new ListNode(9);
		// ListNode l12 = new ListNode(4);
		// ListNode l13 = new ListNode(3);
		// l11.next = l12;
		// l12.next = l13;
		printList(l11);

		ListNode l21 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		ListNode l23 = new ListNode(4);
		l21.next = l22;
		l22.next = l23;
		printList(l21);
		Test t = new Test();
		printList(t.addTwoNumbers(l11, l21));

	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
