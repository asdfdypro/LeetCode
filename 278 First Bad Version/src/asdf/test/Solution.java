package asdf.test;

public class Solution extends VersionControl {

	/**
	 * (第一个出错版本) Given an integer (signed 32 bits), write a function to check
	 * whether it is a power of 4.
	 */
	public int firstBadVersion(int n) {
		if (isBadVersion(1))
			return 1;
		int low = 2, high = n, mid;
		while (low <= high) {
			mid = low + (high - low) / 2;// 注意溢出，不要用相加！！！
			if (isBadVersion(mid)) {
				if (isBadVersion(mid - 1)) {
					high = mid - 1;
				} else {
					return mid;
				}
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.firstBadVersion(5));
	}
}

class VersionControl {
	static int[] version = { 1, 0, 0, 0, 0, 0 };

	boolean isBadVersion(int version) {
		return VersionControl.version[version] > 0;
	}
}