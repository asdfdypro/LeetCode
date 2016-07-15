package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	/**
	 * (K个有序数组合成一个有序数组)Merge k sorted linked lists and return it as one sorted
	 * list. Analyze and describe its complexity.
	 */

	//19ms
	// 堆顶向下调整
	private void toDown(ListNode[] heap, int heapLen, int pos) {
		int p = pos, min;
		ListNode t;
		while (p < heapLen) {
			// 选子节点小的
			if (2 * p + 2 < heapLen)
				min = heap[2 * p + 1].val < heap[2 * p + 2].val ? 2 * p + 1 : 2 * p + 2;
			else if (2 * p + 1 < heapLen)
				min = 2 * p + 1;
			else
				return;

			// 比较父节点
			if (heap[p].val < heap[min].val)
				return;
			else {
				t = heap[p];
				heap[p] = heap[min];
				heap[min] = t;
				p = min;
			}
		}

	}

	public ListNode mergeKLists(ListNode[] lists) {
		// 特殊情况
		if (lists == null || lists.length == 0)
			return null;
		if (lists.length == 1)
			return lists[0];

		ListNode head = null, p;
		ListNode[] heap = new ListNode[lists.length];
		int heapLen = 0;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				heap[heapLen++] = lists[i];
		}

		// 加速
		if (heapLen == 0)
			return null;
		if (heapLen == 1)
			return heap[0];

		// 排序
		Arrays.sort(heap, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1 == null)
					return 1;
				else if (o2 == null)
					return -1;
				else
					return o1.val - o2.val;
			}
		});
		
		
		

		head = heap[0];
		p = head;
		while (heapLen > 0 && heap[0] != null) {
			if (heap[0].next != null) {// 下一个
				heap[0] = heap[0].next;
				toDown(heap, heapLen, 0);
			} else {// 某个为空
				heap[0] = heap[--heapLen];
				toDown(heap, heapLen, 0);
				if (heapLen == 0)
					heap[0] = null;// 收尾！！！
			}
			p.next = heap[0];
			p = p.next;
		}

		return head;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode[] head = new ListNode[3];
		head[0] = new ListNode(0);
		// head[0].next=new ListNode(1);
		head[2] = new ListNode(1);
		// head[1].next=new ListNode(1);

		ListNode h = solution.mergeKLists(head);
		while (h != null) {
			System.out.println(h.val);
			h = h.next;
		}

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}