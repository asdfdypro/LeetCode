package asdf.test;

public class Solution3 {

	/**
	 * (K个有序数组合成一个有序数组)Merge k sorted linked lists and return it as one sorted
	 * list. Analyze and describe its complexity.
	 */

	// 两两归并合并 5ms

	// 合并两个
	private ListNode merge(ListNode list1, ListNode list2) {
		ListNode head, p;
		// 头
		if (list1.val < list2.val) {
			head = list1;
			list1 = list1.next;
		} else {
			head = list2;
			list2 = list2.next;
		}
		p = head;
		// 体
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				p.next = list1;
				list1 = list1.next;
			} else {
				p.next = list2;
				list2 = list2.next;
			}
			p = p.next;
		}
		// 尾
		if (list1 != null)
			p.next = list1;
		if (list2 != null)
			p.next = list2;

		return head;
	}

	// 合并l到r
	private ListNode mergeKLists(ListNode[] heap, int l, int r) {
		if (l < r) {
			if (r - l ==1)
				heap[l] = merge(heap[l], heap[r]);
			else {
				int m = (l + r) / 2;
				heap[l] = merge(mergeKLists(heap, l, m), mergeKLists(heap, m + 1, r));
			}
		}
		return heap[l];
	}

	public ListNode mergeKLists(ListNode[] lists) {
		// 特殊情况
		if (lists == null || lists.length == 0)
			return null;
		if (lists.length == 1)
			return lists[0];

		ListNode[] heap = new ListNode[lists.length];
		int heapLen = 0;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				heap[heapLen++] = lists[i];
			}
		}

		// 加速
		if (heapLen == 0)
			return null;
		if (heapLen == 1)
			return heap[0];

		return mergeKLists(heap, 0, heapLen - 1);
	}

	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		ListNode[] head = new ListNode[2];
		head[0] = new ListNode(1);
		head[0].next = new ListNode(1);
		head[1] = new ListNode(1);
		head[1].next = new ListNode(1);

		ListNode h = solution.mergeKLists(head);
		while (h != null) {
			System.out.println(h.val);
			h = h.next;
		}

	}
}
