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
	 * (字典顺序的下一个) Implement next permutation, which rearranges numbers into the
	 * lexicographically next greater permutation of numbers.
	 * 
	 * If such arrangement is not possible, it must rearrange it as the lowest
	 * possible order (ie, sorted in ascending order).
	 * 
	 * The replacement must be in-place, do not allocate extra memory.
	 * 
	 * Here are some examples. Inputs are in the left-hand column and its
	 * corresponding outputs are in the right-hand column.
	 * 
	 * 1,2,3 → 1,3,2
	 * 
	 * 3,2,1 →1,2,3
	 * 
	 * 1,1,5 → 1,5,1
	 */

	public void nextPermutation(int[] nums) {
		int p = nums.length-1;
		while (p > 0 && nums[p - 1] >= nums[p])//从尾部找第一个升序
			p--;
		if (p == 0)
			Arrays.sort(nums);// 重排序
		else {
			int t;			
			int q=nums.length-1;
			
			p=p-1;
			while(nums[p]>=nums[q])//从尾部选取交换对象
				q--;
			
			t=nums[q];			
			nums[q]=nums[p];
			nums[p]=t;
			Arrays.sort(nums,p+1,nums.length);//排序
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] words = { 1, 2, 1, 1 };
		for (int i = 0; i < 1; i++) {
			solution.nextPermutation(words);
			System.out.println(Arrays.toString(words));
		}
		
//		int[] i={4,3,2,1};
//		Arrays.sort(i,0,2);
//System.out.println(Arrays.toString(i));

	}
}
