package asdf.test;

public class Solution {

	/**
	 * (n个1-n的数只中，出现两次的数) Given an array nums containing n + 1 integers where
	 * each integer is between 1 and n (inclusive), prove that at least one
	 * duplicate number must exist. Assume that there is only one duplicate
	 * number, find the duplicate one.
	 * 
	 * Note:
	 * 
	 * You must not modify the array (assume the array is read only).
	 * 
	 * You must use only constant, O(1) extra space.
	 * 
	 * Your runtime complexity should be less than O(n2).
	 * 
	 * There is only one duplicate number in the array, but it could be repeated
	 * more than once.
	 */
	public int findDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] == nums[j])
					return nums[i];
			}
		}
		return nums[0];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.findDuplicate(new int[] { 1, 2, 3, 2 }));
	}
}
