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
	 * (插入并合并间隔)Given a set of non-overlapping intervals, insert a new interval
	 * into the intervals (merge if necessary).
	 * 
	 * You may assume that the intervals were initially sorted according to
	 * their start times.
	 * 
	 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as
	 * [1,2],[3,10],[12,16]
	 * 
	 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]
	 */

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();
		int len = intervals.size();
		int nowStart = newInterval.start, nowEnd = newInterval.end, theStart, theEnd;
		boolean isInsert = false;
		for (int i = 0; i < len; i++) {
			if (isInsert) {// 是否插入
				res.add(intervals.get(i));
			} else {
				theStart = intervals.get(i).start;
				theEnd = intervals.get(i).end;

				if (theEnd < nowStart)// 小于插入端
					res.add(intervals.get(i));
				else if (theStart > nowEnd) {// 大于插入端
					res.add(new Interval(nowStart, nowEnd));
					res.add(intervals.get(i));
					isInsert = true;
				} else if (theStart < nowStart) {// nowStart向前扩展
					nowStart = theStart;
					if (theEnd > nowEnd)
						nowEnd = theEnd;
				} else {// nowEnd向后扩展
					if (theEnd > nowEnd)
						nowEnd = theEnd;
				}
			}

		}

		if (!isInsert)
			res.add(new Interval(nowStart, nowEnd));

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(4, 5));
		// intervals.add(new Interval(8, 10));
		// intervals.add(new Interval(10, 11));

		List<Interval> res = solution.insert(intervals, new Interval(2, 5));
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
