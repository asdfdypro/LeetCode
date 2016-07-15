package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
	/**
	 * (复制链表，含有随机链接)A linked list is given such that each node contains an
	 * additional random pointer which could point to any node in the list or
	 * null.
	 * 
	 * Return a deep copy of the list.
	 */
	// 利用源表构建关系
	// 首先按照old的顺序，构建new的next关系
	// 然后让old的next指向new，new的random指向old
	// 此时，new.random=new.random.random.next
	// 最后恢复old的next指针

	//4ms
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		RandomListNode oldHead, newHead, newNext, oldNext;
		RandomListNode root = new RandomListNode(head.label);
		List<RandomListNode> oldList = new ArrayList<RandomListNode>();

		// 变换old的next指针
		root.random = head;
		oldHead = head;
		newHead = root;
		while (oldHead.next != null) {
			oldList.add(oldHead);// 记录旧序列
			oldNext = oldHead.next;
			oldHead.next = newHead; // old的next指向new
			newHead.random = oldHead;// new的random指向old
			newNext = new RandomListNode(oldNext.label);
			newHead.next = newNext;

			oldHead = oldNext;
			newHead = newNext;
		}
		oldList.add(oldHead);
		oldHead.next = newHead;
		newHead.random = oldHead;
				
		// 确立新的random关系
		newHead = root;
		while (newHead != null) {
			if (newHead.random.random!=null) {							
				newHead.random = newHead.random.random.next;
			}else {
				newHead.random = null;
			}
			newHead = newHead.next;
		}

		// 恢复old的next关系
		oldHead = head;
		for (int i = 1; i < oldList.size(); i++) {
			oldHead.next = oldList.get(i);
			oldHead = oldHead.next;
		}
		oldHead.next = null;

		return root;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		int[] labels = { 0, 1, 2, 3, 4 };
		RandomListNode[] head = new RandomListNode[labels.length];
		for (int i = head.length - 1; i >= 0; i--) {
			head[i] = new RandomListNode(labels[i]);
			if (i != head.length - 1) {
				head[i].next = head[i + 1];
			}
		}
		head[1].random = head[2];
		head[3].random = head[1];
		head[4].random = head[4];

		RandomListNode.print(head[0]);
		RandomListNode root = solution.copyRandomList(head[0]);
		RandomListNode.print(head[0]);
		RandomListNode.print(root);

	}

}
