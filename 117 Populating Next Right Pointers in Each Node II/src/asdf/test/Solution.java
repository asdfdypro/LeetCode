package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Solution {

	/**
	 * (二叉树的下一个节点)Populate each next pointer to point to its next right node.
	 * If there is no next right node, the next pointer should be set to NULL.
	 * 
	 * Initially, all next pointers are set to NULL.
	 * 
	 * Note:
	 * 
	 * You may only use constant extra space. 
	 * 
	 */

	//宽度优先遍历，使用队列实现
	public void connect(TreeLinkNode root) {
		if (root != null) {
			List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
			list.add(root);
			connect(list);
		}
	}

	private void connect(List<TreeLinkNode> list) {
		List<TreeLinkNode> res = new ArrayList<TreeLinkNode>();
		Iterator<TreeLinkNode> hold = list.iterator();
		TreeLinkNode p, q = null;
		if (hold.hasNext()) {
			p = hold.next();
			while (hold.hasNext()) {
				q = hold.next();
				if (p.left != null)
					res.add(p.left);
				if (p.right != null)
					res.add(p.right);
				p.next = q;
				p = q;
			}
			if (p.left != null)
				res.add(p.left);
			if (p.right != null)
				res.add(p.right);
			connect(res);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeLinkNode root = new TreeLinkNode(0);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		solution.connect(root);

	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
