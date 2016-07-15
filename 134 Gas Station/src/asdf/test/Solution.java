package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (环上和大于0 ，找一个起点，所有累加和一直大于0 ) There are N gas stations along a circular route, where the amount
	 * of gas at station i is gas[i].
	 * 
	 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
	 * travel from station i to its next station (i+1). You begin the journey
	 * with an empty tank at one of the gas stations.
	 * 
	 * Return the starting gas station's index if you can travel around the
	 * circuit once, otherwise return -1.
	 * 
	 * Note: The solution is guaranteed to be unique.
	 */

	// 贪心
	// 当 路程和sum{cost} 大于油量和 sum{gas} 时，显然不能走完全程
	// 当 路程和sum{cost} 大于油量和 sum{gas} 时，可证明一定能走完全程。加入不能走完，至少存在两个端点，两个端点的g1<c1
	// g2<c2，则g1+g2<c1+c2与假设矛盾

	// 从某点开始，准备两个指针pq，p累加差，直到差小于0，q向前走累加差，直到差大于0
	// 等到qp回合时，累加差大于0，qp回合位置为起点
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null)
			return -1;
		if (gas.length != cost.length)
			return -1;
		if (gas.length == 0)
			return -1;

		int q = 0, p = 1%gas.length, sum = gas[0] - cost[0];

		while (p != q) {
			while (p != q && sum >= 0) {
				sum += gas[p] - cost[p];
				p = (p + 1) % gas.length;
			}
			while (p != q && sum < 0) {
				q = (q - 1 + gas.length) % gas.length;
				sum += gas[q] - cost[q];
			}
		}
		if (sum < 0)
			return -1;
		else
			return q;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		 int[] gas = {4};
		 int[] cost = {5};

//		int[] gas = { 8, 2, 9, 3, 5 };
//		int[] cost = { 1, 9, 2, 8, 3 };
		System.out.println(solution.canCompleteCircuit(gas, cost));
	}
}
