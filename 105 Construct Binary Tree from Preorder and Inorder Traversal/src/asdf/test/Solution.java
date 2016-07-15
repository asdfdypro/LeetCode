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
	 * (由前序遍历和中序遍历构建树)Given preorder and inorder traversal of a tree, construct
	 * the binary tree.
	 * 
	 * Note: You may assume that duplicates do not exist in the tree.
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int[] pos = { 0 };
		return buildTree(preorder, pos, inorder, 0, inorder.length - 1);
	}

	// 根在preorder的pos，查询inorder的posFrom到posTo
	private TreeNode buildTree(int[] preorder, int[] pos, int[] inorder, int posFrom, int posTo) {
		if (pos[0] >= preorder.length)
			return null;
		if (posFrom > posTo)
			return null;

		TreeNode root = new TreeNode(preorder[pos[0]]);
		int p = -1;
		for (int i = posFrom; i <= posTo; i++) {
			if (inorder[i] == preorder[pos[0]]) {
				p = i;
				break;
			}
		}
		pos[0] ++;
		root.left = buildTree(preorder, pos, inorder, posFrom, p - 1);
		root.right = buildTree(preorder, pos, inorder, p + 1, posTo);

		return root;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] preorder = {};
		int[] inorder = {};
		
//		int[] preorder = {1,2,4,5,3,6};
//		int[] inorder = {4,2,5,1,6,3};
		TreeNode root = solution.buildTree(preorder, inorder);
		root.printLevel();

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public void print() {
		print(this);
		System.out.println();
	}
	
	public void printLevel() {		
		List<List<Integer>> res =levelOrder(this);
		for (List<Integer> list : res) {
			for (Integer integer : list) {
				System.out.print(integer + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}


	private static void print(TreeNode root) {
		if (root == null)
			return;

		print(root.left);
		System.out.print(root.val + "\t");
		print(root.right);
	}
	
	
	private List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root != null) {
			List<TreeNode> rootList = new ArrayList<TreeNode>();
			rootList.add(root);
			levelOrder(res, rootList);
		}
		return res;
	}

	private void levelOrder(List<List<Integer>> res, List<TreeNode> rootList) {		
		List<Integer> resList = new ArrayList<Integer>();
		List<TreeNode> childList=new ArrayList<TreeNode>();
		for (TreeNode node : rootList) {
			resList.add(node.val);
			if(node.left!=null)
				childList.add(node.left);
			if(node.right!=null)
				childList.add(node.right);			
		}
		res.add(resList);
		if(childList.size()>0)
			levelOrder(res, childList);
	}

}