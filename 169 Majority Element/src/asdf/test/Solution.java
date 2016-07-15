package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	/**
	 * (查询主元素)Given an array of size n, find the majority element. The majority
	 * element is the element that appears more than ⌊ n/2 ⌋ times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 * 
	 */
	//map 26ms
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer n;
		int res=0, len = nums.length / 2;
		for (int i : nums) {
			n = map.get(i);
			if (n == null)
				n = 0;
			map.put(i, ++n);
			if (n >len){
				res = i;
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<int[]> list = new ArrayList<int[]>();
		list.add(new int[] { 1 });
		list.add(new int[] { 2,2 });
		list.add(new int[] { 1,1,2 });
		list.add(new int[] { 1,1,1,2 });
		for (int[] is : list) {
			System.out.println(solution.majorityElement(is));
		}

	}
}
