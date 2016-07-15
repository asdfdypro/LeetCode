package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {

	/**
	 * (完全二叉树叶子数目)Given a complete binary tree, count the number of nodes.
	 * 
	 * Definition of a complete binary tree from Wikipedia: In a complete binary
	 * tree every level, except possibly the last, is completely filled, and all
	 * nodes in the last level are as far left as possible. It can have between
	 */

	  public int countNodes(TreeNode root) {  
	        if(root==null) return 0;  
	          
	        int l = getLeft(root) + 1;  
	        int r = getRight(root) + 1;  
	          
	        if(l==r) {  //满二叉树
	            return (2<<(l-1)) - 1;  
	        } else {  //完全二叉树
	            return countNodes(root.left) + countNodes(root.right) + 1;  
	        }  
	    }  
	      
	    private int getLeft(TreeNode root) {  
	        int count = 0;  
	        while(root.left!=null) {  
	            root = root.left;  
	            ++count;  
	        }  
	        return count;  
	    }  
	      
	    private int getRight(TreeNode root) {  
	        int count = 0;  
	        while(root.right!=null) {  
	            root = root.right;  
	            ++count;  
	        }  
	        return count;  
	    }  

	public static void main(String[] args) {
		Solution solution = new Solution();

		Integer[] vals = { 1, 2, 3, 6, 5,8 };
		TreeNode root = TreeNode.createTree(vals);
		System.out.println(solution.countNodes(root));

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static TreeNode createTree(Integer[] vals) {
		TreeNode[] nodes = new TreeNode[vals.length];
		for (int i = 0; i < vals.length; i++) {
			if (vals[i] != null)
				nodes[i] = new TreeNode(vals[i]);
		}
		for (int i = 0; i < vals.length; i++) {
			if (2 * i + 1 < vals.length)
				nodes[i].left = nodes[2 * i + 1];
			if (2 * i + 2 < vals.length)
				nodes[i].right = nodes[2 * i + 2];
		}
		return nodes[0];
	}
}