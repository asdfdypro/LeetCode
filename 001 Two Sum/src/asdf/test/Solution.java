package asdf.test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> res = new HashMap<>();
		int[] a = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (res.get(target - nums[i]) != null) {
				a[0] = res.get(target - nums[i]) + 1;
				a[1] = i + 1;
				return a;
			}
			res.put(nums[i], i);
		}
		return null;
	}
}