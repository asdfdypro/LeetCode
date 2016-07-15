package asdf.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	/**
	 * (第K大的数)Find the kth largest element in an unsorted array. Note that it is
	 * the kth largest element in the sorted order, not the kth distinct
	 * element.
	 * 
	 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
	 * 
	 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
	 */
//队列83ms 排序3ms  	优先队列19 ms 
	public int findKthLargest(int[] nums, int k) {

		//队列
//		int[] kNums = new int[k];
//		Arrays.fill(kNums, Integer.MIN_VALUE);
//
//		int j;
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] > kNums[k - 1]) {
//				j = k - 2;
//				for (; j >= 0; j--) {
//					if (nums[i] > kNums[j]) {
//						kNums[j + 1] = kNums[j];
//					} else {
//						kNums[j + 1] = nums[i];
//						break;
//					}
//				}
//				if (j < 1&&nums[i] > kNums[0])
//					kNums[0] = nums[i];
//			}
//		}
//
//		return kNums[k - 1];
		
		//排序
		// Arrays.sort(nums);
		// return nums[nums.length-k];
		
		//优先队列
		 Queue<Integer> p = new PriorityQueue<Integer>();
	        for(int i = 0 ; i < nums.length; i++){
	            p.add(nums[i]);
	            if(p.size()>k) p.poll();
	        }
	        return p.poll();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 6));
		System.out.println(solution.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 5));
		System.out.println(solution.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 1));
		System.out.println(solution.findKthLargest(new int[] { 5, 2, 4, 1, 3, 6, 0 }, 4));

	}
}
