package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution {

	/**
	 * (最短路径)Given a triangle, find the minimum path sum from top to bottom.
	 * Each step you may move to adjacent numbers on the row below.
	 * 
	 * For example, given the following triangle
	 * 
	 * [ [2],
	 * 
	 * [3,4],
	 * 
	 * [6,5,7],
	 * 
	 * [4,1,8,3] ]
	 * 
	 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	 */

	// 前序遍历
	public int minimumTotal(List<List<Integer>> triangle) {
		
		int l=triangle.size(),t,h;
		List<Integer>  now,res=triangle.get(0);
		for (int i = 1; i < l; i++) {
			now=triangle.get(i);
			t=now.size()-1;
			h=now.get(t);			
			
			now.set(0, now.get(0)+res.get(0));		
			for (int j = 1; j < t; j++) {
				now.set(j, now.get(j)+(res.get(j-1)<res.get(j)?res.get(j-1):res.get(j)));
			}			
			now.set(t, now.get(t)+res.get(res.size()-1));
			
			res=now;
		}
		

		int m = Integer.MAX_VALUE;
		for (Integer integer : res) {
			if (integer < m) {
				m = integer;
			}
		}
		return m;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> triangle=new ArrayList<List<Integer>>();
		List<Integer> a=new ArrayList<Integer>();
		a.add(-1);
		
		List<Integer> b=new ArrayList<Integer>();
		b.add(-2);b.add(-3);
		
		triangle.add(a);triangle.add(b);
		
		System.out.println(solution.minimumTotal(triangle));
	}

}
