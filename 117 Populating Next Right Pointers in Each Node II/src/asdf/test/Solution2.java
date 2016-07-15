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
	 * (二叉树的下一个节点)Populate each next pointer to point to its next right node. If
	 * there is no next right node, the next pointer should be set to NULL.
	 * 
	 * Initially, all next pointers are set to NULL.
	 * 
	 * Note:
	 * 
	 * You may only use constant extra space.
	 * 
	 */

	// 宽度优先遍历，上层的next就是下层的遍历队列
	public void connect(TreeLinkNode root) {
		if (root != null) {
			TreeLinkNode p = root;//队列，层次循环
			TreeLinkNode next = null;//下一层开始
			TreeLinkNode hold=null;//上一个元素
			while (p != null) {
				if(p.left!=null){
					if(next==null){
						next=p.left;
						hold=p.left;						
					}else{
						hold.next=p.left;
						hold=p.left;
					}		
				}
				
				if(p.right!=null){
					if(next==null){
						next=p.right;
						hold=p.right;						
					}else{
						hold.next=p.right;
						hold=p.right;
					}		
				}	
				
				p = p.next;
			}
			if (next != null)
				connect(next);
		}
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		TreeLinkNode root = new TreeLinkNode(0);
		 root.left = new TreeLinkNode(2);
		 root.right = new TreeLinkNode(3);
		solution.connect(root);
		System.out.println(root.next);
		System.out.println(root.left.next);
		System.out.println(root.right.next);
	}

}
