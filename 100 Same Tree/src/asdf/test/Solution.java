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
	 * (判断两个树是否相同) Given two binary trees, write a function to check if they are
	 * equal or not.
	 * 
	 * Two binary trees are considered equal if they are structurally identical
	 * and the nodes have the same value.
	 * 
	 */

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null)
			return true;
		else if (p!=null&&q!=null)			
			return p.val==q.val&&isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
		else
			return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		TreeNode root = new TreeNode(1);
		TreeNode l = new TreeNode(2);
		TreeNode r = new TreeNode(3);
		// root.left = l;
		root.right = r;

		// l.left = new TreeNode(4);
		// l.right = new TreeNode(5);

		r.left = new TreeNode(6);
		// r.right = new TreeNode(7);

		System.out.println(solution.isSameTree(root, root));
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