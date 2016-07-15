package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {

	/**
	 * (矩形总共覆盖的大小)Find the total area covered by two rectilinear rectangles in a
	 * 2D plane.
	 * 
	 * Each rectangle is defined by its bottom left corner and top right corner
	 */
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int row = 0, col = 0;
		if (A < E) {
			if (C <= E)
				row=0;
			else if (C >= G)
				row = G - E;
			else
				row = C - E;
		} else {
			if (A >= G)
				row=0;
			else if (C >= G)
				row = G - A;
			else
				row = C - A;
		}

		if (B < F) {
			if (D <= F)
				col=0;
			else if (D >= H)
				col = H - F;
			else
				col = D - F;
		} else {
			if (B >= H)
				col=0;
			else if (D >= H)
				col = H - B;
			else
				col = D - B;
		}
		return (C - A) * (D - B) + (G - E) * (H - F) - row * col;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
//		System.out.println(solution.computeArea(0, 0, 0, 0, -1, -1, 1, 1));// 全包含
		System.out.println(solution.computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
	}
}
