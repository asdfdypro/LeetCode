package asdf.test;

public class Solution2 {

	/**
	 * (移除元素) Given an array and a value, remove all instances of that value in
	 * place and return the new length.
	 * 
	 * The order of elements can be changed. It doesn't matter what you leave
	 * beyond the new len
	 */

	// 两个指针，由于顺序可变，将尾部的向前调换
	public int removeElement(int[] nums, int val) {
		int m = 0, p = 0, q = nums.length-1;
		while (q>=0&&nums[q] == val) {
			q--;
			m++;
		}

		while (p <= q) {
			if (nums[p] == val) {
				m++;
				nums[p] = nums[q];
				p++;
				q--;
				while (p <= q&&nums[q] == val) {
					q--;
					m++;
				}
			} else {
				p++;
			}
		}
		
		return nums.length - m;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		int[] nums = { 1, 1, 2, 1 };
		int m = solution.removeElement(nums, 1);
		for (int i = 0; i < m; i++) {
			System.out.println(nums[i]);
		}

	}
}
