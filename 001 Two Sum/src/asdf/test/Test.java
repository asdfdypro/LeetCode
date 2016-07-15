package asdf.test;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		Solution solution=new Solution();
		int[] nums={2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(solution.twoSum(nums, target)));
	}

}
