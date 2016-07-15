package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	/**
	 * (有序数组中，删除相同元素，并保留2个) Follow up for "Remove Duplicates": What if
	 * duplicates are allowed at most twice?
	 * 
	 * For example, Given sorted array nums = [1,1,1,2,2,3],
	 * 
	 * Your function should return length = 5, with the first five elements of
	 * nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the
	 * new length.
	 */

	public int removeDuplicates(int[] nums) {
		if (nums.length < 3)
			return nums.length;
		
		int p = 0;
		int m=nums[0];
		boolean isOk=false;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]!=m){
				nums[p++] = m;
				m=nums[i];
				isOk=false;
			}else{
				if(!isOk){
					isOk=true;
				nums[p++] = m;
				}
			}				
		}
		nums[p++] = m;
		return p;	
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 1, 1, 1,1,1,1,1,1 ,2,2,2, 2, 3 };
		System.out.println(solution.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}
}
