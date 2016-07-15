package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (合并间隔)Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * For example,
	 * 
	 * Given [1,3],[2,6],[8,10],[15,18],
	 * 
	 * return [1,6],[8,10],[15,18].
	 */

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		int len = intervals.size();
		if (len < 1)
			return res;

		// 先按start排序
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		int nowStart = intervals.get(0).start, nowEnd = intervals.get(0).end, theStart, theEnd;
		for (int i = 1; i < len; i++) {
			theStart = intervals.get(i).start;
			theEnd = intervals.get(i).end;

			if (theStart <= nowEnd) {// 重叠
				if (theEnd > nowEnd)
					nowEnd = theEnd;
			}else{//不重叠
				res.add(new Interval(nowStart, nowEnd));
				nowStart=theStart;
				nowEnd=theEnd;
			}
		}
		res.add(new Interval(nowStart, nowEnd));

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(3, 4));
//		intervals.add(new Interval(8, 10));
//		intervals.add(new Interval(10, 11));

		List<Interval> res = solution.merge(intervals);
		System.out.println(res.size());

		for (Interval n : res) {
			System.out.println(n + ",");
		}
	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

}
