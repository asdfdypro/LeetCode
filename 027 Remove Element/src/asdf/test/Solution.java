package asdf.test;

public class Solution {

	/**
	 * (移除元素) Given an array and a value, remove all instances of that value in
	 * place and return the new length.
	 * 
	 * The order of elements can be changed. It doesn't matter what you leave
	 * beyond the new len
	 */

	//向前移动
	public int removeElement(int[] nums, int val) {
		int m = 0,p=0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val){
				m++;				
			}else{
				nums[p++]=nums[i];
			}
		}
		return nums.length - m;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] nums = { 1, 3, 4, 5 };
		int m=solution.removeElement(nums, 3);
		for (int i = 0; i <m; i++) {
			System.out.println(nums[i]);
		}

	}
}
