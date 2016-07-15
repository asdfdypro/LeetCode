package asdf.test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	/**
	 * (复制链表，含有随机链接)A linked list is given such that each node contains an
	 * additional random pointer which could point to any node in the list or
	 * null.
	 * 
	 * Return a deep copy of the list.
	 */
	//使用map存储
	//7ms
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		Map<RandomListNode, RandomListNode> copyMap = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newHead, newNext, newRandom;
		RandomListNode root = new RandomListNode(head.label);
		copyMap.put(head, root);
		while (head != null) {
			newHead = copyMap.get(head);
//			if (newHead == null) {
//				newHead = new RandomListNode(head.label);
//				copyMap.put(head, newHead);
//			}

			if (head.next != null) {
				newNext = copyMap.get(head.next);
				if (newNext == null) {
					newNext = new RandomListNode(head.next.label);
					copyMap.put(head.next, newNext);
				}
				newHead.next = newNext;
			}

			if (head.random != null) {
				newRandom = copyMap.get(head.random);
				if (newRandom == null) {
					newRandom = new RandomListNode(head.random.label);
					copyMap.put(head.random, newRandom);
				}
				newHead.random = newRandom;
			}

			head = head.next;
		}

		return root;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
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
		System.out.println(root);
		RandomListNode.print(root);

	}

}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}

	public static void print(RandomListNode root) {

		while (root != null) {
			System.out
					.println(String.format("%s:next=%s;random=%s;", root, root.next, root.random));
			root = root.next;
		}
		System.out.println();
	}

	@Override
	public String toString() {
		return String.valueOf(label);
	}

}