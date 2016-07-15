package asdf.test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * (输出全排列的第n个)The set [1,2,3,…,n] contains a total of n! unique
	 * permutations.
	 * 
	 * By listing and labeling all of the permutations in order, We get the
	 * following sequence (ie, for n = 3):
	 * 
	 * "123" "132" "213" "231" "312" "321"
	 * 
	 * Given n and k, return the kth permutation sequence.
	 */

	//i位置上为k/(n-i)! k=其余数
	public String getPermutation(int n, int k) {
		int[] factorial = new int[n];
		List<Integer> mask = new ArrayList<Integer>();//ArrayList无影响
		String res = "";//stringbuffer无影响
		
		// 计算阶乘,准备数组
		int t = 1;
		factorial[0]=1;
		mask.add(1);
		for (int i = 1; i < n; i++) {
			t *= i;
			factorial[i] = t;
			mask.add(i+1);
		}
		
		int pos;
		k--;
		for (int i = 1; i <=n; i++) {
			pos=k/factorial[n-i];
			k=k%factorial[n-i];
			res+=mask.get(pos);
			mask.remove(pos);
		}		

		return res.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		for (int i = 1; i < 7; i++) {
			System.out.println(solution.getPermutation(3, i));
		}
	}

}
