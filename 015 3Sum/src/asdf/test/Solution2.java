package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2 {

	/**
	 * (三数和为0)Given an array S of n integers, are there elements a, b, c in S
	 * such that a + b + c = 0? Find all unique triplets in the array which
	 * gives the sum of zero.
	 * 
	 * Note: * Elements in a triplet (a,b,c) must be in non-descending order.
	 * (ie, a ≤ b ≤ c)
	 * 
	 * The solution set must not contain duplicate triplets.
	 */

	// 先排序，使用双指针两头查询和为某个值的值,结果不用排序，时间n^2

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);

		int i, j;
		int len = nums.length;
		for (int k = 0; k < len-2; k++) {
			if (k > 0 && nums[k] == nums[k - 1])
				continue; // 加速
			i = k + 1;
			j = len-1;
			while (i < j) {
				if (nums[i] + nums[j] > -nums[k])
					do
						j--;
					while (i < j&& j + 1<len&& nums[j] == nums[j + 1]);
				else if (nums[i] + nums[j] < -nums[k])
					do
						i++;
					while (i < j &&i - 1>k&& nums[i] == nums[i - 1]);
				else {
					List<Integer> ans = new ArrayList<Integer>();
					ans.add(nums[k]);
					ans.add(nums[i]);
					ans.add(nums[j]);
					res.add(ans);
					// 继续
					while (i < j && nums[i] == nums[i + 1])
						i++;
					while (i < j && nums[j] == nums[j - 1])
						j--;
					i++;
					j--;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {

		Solution2 solution = new Solution2();
		int[] a = { 0, 0, 0, 0 };
		int[] b = { -1, 0, 1, 2, -1 };
		int[] c = { -1, 0, 1, 2, -1, -4, -1, 2, -2, 1, 3 };
		int[] d = { -5, 4, 5, -1, 3, 7, -8, -4, 7, -5, -4, 0, -9, -7, 7, -4, 1, -2, 3, 7, 4, 0, -3,
				3, -9, 5 };
		int[]e={-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};

		System.out.println(solution.threeSum(a).size());
		System.out.println(solution.threeSum(b).size());
		System.out.println(solution.threeSum(c).size());
		System.out.println(solution.threeSum(d).size());
		System.out.println(solution.threeSum(e).size());
	}
}
