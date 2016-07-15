package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution {

	/**
	 * (统计n个数，组成的二分查找树的所有可能结果)Given n, generate all structurally unique BST's
	 * (binary search trees) that store values 1...n.
	 * 
	 * For example, Given n = 3, your program should return all 5 unique BST's
	 * shown below.
	 * 
	 */

	// DP
	// 先搞定结构，再填数字
	// 二分查找树的中序遍历为顺序值
	public List<TreeNode> generateTrees(int n) {

		if (n == 0)
			return new ArrayList<TreeNode>();

		List<TreeNode>[] resStructure = new List[n + 1];// 结构

		resStructure[0] = new ArrayList<TreeNode>();
		resStructure[0].add(null);

		resStructure[1] = new ArrayList<TreeNode>();
		resStructure[1].add(new TreeNode(1));

		TreeNode root;
		for (int i = 2; i <= n; i++) {
			resStructure[i] = new ArrayList<TreeNode>();
			for (int j = 0; j <= i - 1; j++) {
				for (TreeNode left : resStructure[j]) {
					for (TreeNode right : resStructure[i - j - 1]) {
						root = new TreeNode(0);
						root.left = copyTree(left);
						root.right = copyTree(right);
						resStructure[i].add(root);
					}
				}
			}
		}

		for (TreeNode r : resStructure[n]) {
			fillTree(r, 1);
		}
		return resStructure[n];
	}

	// 复制一课树
	private TreeNode copyTree(TreeNode root) {
		if (root == null)
			return null;

		TreeNode rootNew = new TreeNode(root.val);
		rootNew.left = copyTree(root.left);
		rootNew.right = copyTree(root.right);
		return rootNew;
	}

	// 中序遍历 填充
	private int fillTree(TreeNode root, int i) {
		if (root == null)
			return i;

		i = fillTree(root.left, i);
		root.val = i++;
		i = fillTree(root.right, i);
		return i;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int size = solution.generateTrees(9).size();
		System.out.println(size);

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}