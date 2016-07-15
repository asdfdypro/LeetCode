package asdf.test;

public class Solution2 {

	/**
	 * 查找两个有序数组的中位数There are two sorted arrays nums1 and nums2 of size m and n
	 * respectively. Find the median of the two sorted arrays. The overall run
	 * time complexity should be O(log (m+n)).
	 */
	// 搞清楚关系，画图，精确
	// 两层二分查找，搞清楚对应关系，每次查找必须找到精确的位置
	// 优化，一次查出所有数字

	// 从nums数组中，查询小于等于num的最大数的位置
	public int findPosSortedArrays(int[] nums, int num) {
		if (nums.length == 0)
			return -1;

		int s = 0, t = nums.length - 1;
		int pos = (s + t) / 2;
		while (s <= t && num != nums[pos]) {
			if (num > nums[pos])
				s = pos + 1;
			else
				t = pos - 1;
			if (s <= t) {
				pos = (s + t) / 2;
			}
		}
		// 选取最右面
		while (pos + 1 < nums.length && nums[pos + 1] == num)
			pos++;
		// 保证小于等于
		while (pos >= 0 && num < nums[pos])
			pos--;
		return pos;
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int allLength = nums1.length + nums2.length;// 总长度
		int pos = allLength / 2;

		if (nums2.length > nums1.length) {
			int[] temp = nums2;
			nums2 = nums1;
			nums1 = temp;
		}

		int s1 = 0, t1 = nums1.length - 1;
		int localpos1 = (s1 + t1) / 2;
		int localpos2 = findPosSortedArrays(nums2, nums1[localpos1]);
		int localpos = localpos1 + localpos2 + 1;
		while (s1 <= t1 && localpos != pos) {
			if (localpos < pos)
				s1 = localpos1 + 1;
			else
				t1 = localpos1 - 1;
			if (s1 <= t1) {
				localpos1 = (s1 + t1) / 2;
				localpos2 = findPosSortedArrays(nums2, nums1[localpos1]);
				localpos = localpos1 + localpos2 + 1;
			}
		}

		double num;// 要查找的数字
		// 位置正好，正好是nums1中localpos1的位置
		if (localpos == pos) {
			num = nums1[localpos1];
			if (allLength % 2 == 0) {// 偶数，前一个				
				if (localpos2<0||(localpos1-1>=0&&nums1[localpos1-1]>nums2[localpos2]))//前一个可能在nums1
					num = (num +  nums1[localpos1-1]) / 2.0;
				else
				num = (num + nums2[localpos2]) / 2.0;				
			}
		} else if (localpos < pos) {// 往后的位置，在nums2中继续往后差值
			System.out.println("2");
			num = nums2[localpos2 + pos - localpos];
			if (allLength % 2 == 0) {// 偶数，前一个
				if (pos - localpos == 1)//前一个可能在nums1
					num = (num + nums1[localpos1]) / 2.0;
				else
					num = (num + nums2[localpos2 + pos - localpos - 1]) / 2.0;
			}
		} else {// 往前的位置，在nums2中继续往前差值加1(还得算上num2上对应位置的元素)
			System.out.println("3");
			num = nums2[localpos2 + pos - localpos + 1];
			if (allLength % 2 == 0) {// 偶数，前一个
				 if(localpos2 + pos - localpos<0||(localpos1-1>=0&&nums2[localpos2 + pos - localpos]<nums1[localpos1-1]))//前一个可能在nums1	
					 num = (num +  nums1[localpos1-1]) / 2.0;
				 else
					 num = (num +  nums2[localpos2 + pos - localpos]) / 2.0;					 
			}
		}

		return num;

	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		int[] a = {};
		int[] b = { 1 };
		int[] c = { 2, 3, 4 };
		int[] d = { 1, 2, 3, 4, 5, 6 };
		int[] e = { 6, 7, 8, 9, 10, 11 };

		int[] f = { 1, 1, 1, 3 };
		// System.out.println(solution.findPosSortedArrays(f, 2));

		for (int i = 0; i < 10; i++) {

			// System.out.println(solution.findNumberSortedArrays(c, c, i));
		}

//		System.out.println(solution.findMedianSortedArrays(a, b));
		System.out.println(solution.findMedianSortedArrays(b, c));
//		System.out.println(solution.findMedianSortedArrays(c, c));
//		System.out.println(solution.findMedianSortedArrays(c, e));
//		System.out.println(solution.findMedianSortedArrays(d, d));

	}
}