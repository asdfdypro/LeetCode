package asdf.test;

public class Solution {

	/**
	 * (图片顺时针转动90度) You are given an n x n 2D matrix representing an image.
	 * 
	 * Rotate the image by 90 degrees (clockwise).
	 * 
	 * Follow up: Could you do this in-place?
	 */

	// (i,j)--->(j,n-i) [既：(i,j)=(n-j,i)]循环替换
	public void rotate(int[][] matrix) {
		int n = matrix.length - 1;
		int m = matrix.length / 2;
		int k=m+matrix.length%2;//奇数横向多转1次
		int t;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < k; j++) {
				t = matrix[i][j];
				matrix[i][j] = matrix[n - j][i];
				matrix[n - j][i] = matrix[n - i][n - j];
				matrix[n - i][n - j] = matrix[j][n - i];
				matrix[j][n - i] = t;
			}
		}
	}
	//偶数
	//1	1			1	1
	//1	1			1	1
	//
	//1	1			1	1
	//1	1			1	1
	
	//奇数
	//1	1	1				1	1
	//1	1	1				1	1
	//							1	1
	//1	1		1	
	//1	1				1	1	1
	//1	1				1	1	1

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] matrix = 			
//			{{1}};
//			{ { 1, 2  }, { 3,4} };
		{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//		{ { 1, 2, 3 ,4}, {  5, 6,7, 8 }, { 9,10,11,12 },{13,14,15,16} };
		
		solution.rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " , ");
			}
			System.out.println();
		}
	}

}
