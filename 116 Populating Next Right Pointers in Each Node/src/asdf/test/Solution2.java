package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Solution2 {

	/**
	 * (满二叉树的下一个节点)Populate each next pointer to point to its next right node.
	 * If there is no next right node, the next pointer should be set to NULL.
	 * 
	 * Initially, all next pointers are set to NULL.
	 * 
	 * Note:
	 * 
	 * You may only use constant extra space.
	 * 
	 * You may assume that it is a perfect binary tree (ie, all leaves are at
	 * the same level, and every parent has two children).
	 */

	// 宽度优先遍历，上层的next就是下层的遍历队列
	public void connect(TreeLinkNode root) {
		if (root != null&&root.left!=null) {			
			root.left.next=root.right;			
			TreeLinkNode hold=root.right;			
			TreeLinkNode p = root.next;
			while (p != null) {
				hold.next=p.left;
				p.left.next=p.right;
				hold=p.right;
				p = p.next;
			}
			if (root.left.left != null)
				connect(root.left);
		}
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		TreeLinkNode root = new TreeLinkNode(0);
//		root.left = new TreeLinkNode(2);
//		root.right = new TreeLinkNode(3);
		solution.connect(root);

	}

}
