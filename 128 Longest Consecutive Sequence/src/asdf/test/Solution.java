package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

	/**
	 * (最长连续子串) Given an unsorted array of integers, find the length of the
	 * longest consecutive elements sequence.
	 * 
	 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive
	 * elements sequence is [1, 2, 3, 4]. Return its length: 4.
	 * 
	 * Your algorithm should run in O(n) complexity.
	 */

	//并查集
	//考虑重复元素
	
	//并查集只能通过关系级联，不能全部修改，效率低
	//关系级联后，最长查找路径较少，且查找一次后，后面元素路径缩短，平均效率较好
	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> groupID = new HashMap<Integer, Integer>(nums.length);// 元素对应的组号
		int[] groupRelationship = new int[nums.length];// 组元素关系
		Arrays.fill(groupRelationship, -1);//-1表示跟
		int[] groupCount = new int[nums.length];// 组元素数量
		
		Integer l, r;
		for (int i = 0; i < nums.length; i++) {
			if(groupID.get(nums[i])!=null)//重复
				continue;
			
			if (nums[i] > Integer.MIN_VALUE)
				l = groupID.get(nums[i] - 1);
			else
				l = null;
			
			if (nums[i] < Integer.MAX_VALUE)
				r = groupID.get(nums[i] + 1);
			else
				r = null;
			
			if(l==null&&r==null){//创建新元素
				groupID.put(nums[i], i);
				groupCount[i]++;
			}else if(l==null){//右边有元素
				while(groupRelationship[r]!=-1)
					r=groupRelationship[r];
				groupID.put(nums[i], r);				
				groupCount[r]++;
			}else if(r==null){//左边有元素
				while(groupRelationship[l]!=-1)
					l=groupRelationship[l];
				groupID.put(nums[i], l);				
				groupCount[l]++;
			}else{//联合元素
				while(groupRelationship[r]!=-1)
					r=groupRelationship[r];
				while(groupRelationship[l]!=-1)
					l=groupRelationship[l];
				groupRelationship[l]=i;
				groupRelationship[r]=i;
				groupID.put(nums[i], i);
				groupCount[i]=groupCount[l]+groupCount[r]+1;				
			}		
		}
		
		int max=1;
		for (int i : groupCount) {
			if(i>max)
				max=i;
		}

		return max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] nums =
//			{ 100, 4, 200, 1, 3, 2,5 };
			{1,2,0,1};
		System.out.println(solution.longestConsecutive(nums));

	}

}
