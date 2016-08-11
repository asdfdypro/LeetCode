package asdf.test;


/**
 * (奇偶链表)
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class Solution {

    public ListNode oddEvenList(ListNode head) {
        ListNode p = head;
        ListNode odd = null, even = null, evenHold = null;
        if (p != null) {
            odd = p;
            p = p.next;
        }
        if (p != null) {
            even = p;
            evenHold = even;
            p = p.next;
        }
        while (p != null) {

            if (p != null) {
                odd.next = p;
                odd = odd.next;
                p = p.next;
            }
            if (p != null) {
                even.next = p;
                even = even.next;
                p = p.next;
            }

        }
        if (odd != null)
            odd.next = evenHold;
        if (even != null)
            even.next = null;


        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head;


        head = ListNode.createByArrays(new int[]{});
        head = solution.oddEvenList(head);
        ListNode.printf(head);

        head = ListNode.createByArrays(new int[]{1});
        head = solution.oddEvenList(head);
        ListNode.printf(head);

        head = ListNode.createByArrays(new int[]{1, 2});
        head = solution.oddEvenList(head);
        ListNode.printf(head);

        head = ListNode.createByArrays(new int[]{1, 2, 3});
        head = solution.oddEvenList(head);
        ListNode.printf(head);


        head = ListNode.createByArrays(new int[]{1, 2, 3, 4});
        head = solution.oddEvenList(head);
        ListNode.printf(head);

        head = ListNode.createByArrays(new int[]{1, 2, 3, 4, 5});
        head = solution.oddEvenList(head);
        ListNode.printf(head);

        head = ListNode.createByArrays(new int[]{1, 2, 3, 4, 5, 6});
        head = solution.oddEvenList(head);
        ListNode.printf(head);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode createByArrays(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }

        return head;
    }

    public static void printf(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            sb.append(',');
            head = head.next;
        }

        sb.append("]");
        System.out.println(sb.toString());
    }

}
