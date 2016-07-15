package asdf.test;


public class Solution {

	/**
	 * (统计n个数，组成的二分查找树的种类数)Given n, how many structurally unique BST's (binary
	 * search trees) that store values 1...n?
	 * 
	 */
	// DP
	// 卡特兰数
	// h(0)=1,h(1)=1
	// h(n)= h(0)*h(n-1)+h(1)*h(n-2) + ... + h(n-1)h(0) (n>=2)
	// h(n)=h(n-1)*(4*n-2)/(n+1);

	// 递推关系的解为：
	// h(n)=C(2n,n)/(n+1) (n=0,1,2,...)
	// h(n)=c(2n,n)-c(2n,n-1)(n=0,1,2,...)
	public int numTrees(int n) {
		if (n < 1)
			return 0;
		int[] f = new int[n + 1];
		f[0] = 1;
		f[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				f[i] += f[j] * f[i - j - 1];
			}
		}

		return f[n];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 1; i < 10; i++) {

			System.out.println(solution.numTrees(i));
		}

	}
}
