package asdf.test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * (统计中位数)Median is the middle value in an ordered integer list. If the size of
 * the list is even, there is no middle value. So the median is the mean of the
 * two middle value. Examples:
 * 
 * [2,3,4] , the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data
 * structure. double findMedian() - Return the median of all elements so far.
 * 
 * For example:
 * 
 * add(1)
 * 
 * add(2)
 * 
 * findMedian() -> 1.5
 * 
 * add(3)
 * 
 * findMedian() -> 2
 * 
 * @author asdf
 * @date 2016-6-12
 */
public class MedianFinder {
	private Queue<Integer> lowHeap;
	private Queue<Integer> highHeap;
	private Integer mid;

	public MedianFinder() {
		lowHeap = new PriorityQueue<Integer>(100, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.intValue() - o1.intValue();
			}
		});
		highHeap = new PriorityQueue<Integer>();
		mid = null;
	}

	// Adds a number into the data structure.
	public void addNum(int num) {
		if (lowHeap.isEmpty()) {// 没有或一个元素
			if (mid == null)
				mid = num;
			else {
				if (mid < num) {
					lowHeap.offer(mid);
					highHeap.offer(num);
				} else {
					lowHeap.offer(num);
					highHeap.offer(mid);
				}
				mid = null;
			}
		} else if (mid == null) {// 当前偶数个元素
			if (num < lowHeap.peek()) {
				mid = lowHeap.poll();
				lowHeap.offer(num);
			} else if (num > highHeap.peek()) {
				mid = highHeap.poll();
				highHeap.offer(num);
			} else {
				mid = num;
			}
		} else {// 奇数个元素
			if (num < mid) {
				lowHeap.offer(num);
				highHeap.offer(mid);
			} else {
				lowHeap.offer(mid);
				highHeap.offer(num);
			}
			mid = null;
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (mid == null)
			return (highHeap.peek() + lowHeap.peek()) / 2.0f;
		return mid;
	}

	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		System.out.println(mf.findMedian());
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
		mf.addNum(4);
		System.out.println(mf.findMedian());
		mf.addNum(5);
		System.out.println(mf.findMedian());
		mf.addNum(6);
		System.out.println(mf.findMedian());
	}
}
