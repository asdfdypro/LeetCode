package asdf.test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	/**
	 * (窗口内最大值) Given an array nums, there is a sliding window of size k which
	 * is moving from the very left of the array to the very right. You can only
	 * see the k numbers in the window. Each time the sliding window moves right
	 * by one position.
	 * 
	 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3. * Therefore,
	 * return the max sliding window as [3,3,5,5,6,7].
	 * 
	 * Note: You may assume k is always valid, ie: 1 ≤ k ≤ input array's size
	 * for non-empty array.
	 * 
	 * Follow up: Could you solve it in linear time?
	 * 
	 * Hint:
	 * 
	 * How about using a data structure such as deque (double-ended queue)? The
	 * queue size need not be the same as the window’s size. Remove redundant
	 * elements and the queue should store only elements that need to be
	 * consider
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length==0)
			return new int[]{};
		int[] res = new int[nums.length - k + 1];
		int[] heap = new int[k];// 堆，对中存的是数组在nums中的位置
		int[] pos = new int[nums.length];// 存储数组元素在堆中的位置
		int i;
		for (i = 0; i < k; i++) {
			heap[i] = i;
			heapUp(nums, heap, pos, i);
		}
		int parent, p;
		for (; i < nums.length; i++) {
			res[i-k]=nums[heap[0]];
			p = pos[i - k];
			heap[p] = i;
			pos[i] = p;
			parent = (p - 1) >>> 1;
			if (p==0||nums[i] <= nums[heap[parent]])
				heapDown(nums, heap, pos, p);
			else{
				heapUp(nums, heap, pos, p);
			}
		}
		res[i-k]=nums[heap[0]];
		
		return res;
	}

	private void heapDown(int[] nums, int[] heap, int[] pos, int heapPos) {
		int half = heap.length >>> 1;
		int x = heap[heapPos];
		while (heapPos < half) {
			int child = (heapPos << 1) + 1;
			int c = heap[child];
			int right = child + 1;
			if (right < heap.length && nums[heap[right]] > nums[c])
				c = heap[child = right];
			if (nums[x] >= nums[c])
				break;
			heap[heapPos] = c;
			pos[c] = heapPos;
			heapPos = child;
		}
		heap[heapPos] = x;
		pos[x] = heapPos;
	}

	private void heapUp(int[] nums, int[] heap, int[] pos, int heapPos) {
		int x = heap[heapPos];
		while (heapPos > 0) {
			int parent = (heapPos - 1) >>> 1;
			int e = heap[parent];
			if (nums[x] <= nums[e])
				break;
			heap[heapPos] = e;
			pos[e] = heapPos;
			heapPos = parent;
		}
		heap[heapPos] = x;
		pos[x] = heapPos;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5,
				3, 6, 7 }, 3)));
		System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[] {  }, 0)));
		System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[] { 3 }, 1)));
	}
}
