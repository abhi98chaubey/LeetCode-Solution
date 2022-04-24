/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
	return helper(head, null);
}


private static ListNode getMiddle(ListNode head, ListNode stopper) {
	if (head == null) {
		return null;
	}

	ListNode fast = head;
	ListNode slow = head;

	while (fast != stopper && fast.next != stopper) {
		slow = slow.next;
		fast = fast.next.next;
	}

	return slow;
}


private static TreeNode helper(ListNode head, ListNode stopper) {
	if (head == null) {
		return null;
	}

	if (head == stopper) {
		return null;
	}

	ListNode middle = getMiddle(head, stopper);
	TreeNode root = new TreeNode(middle.val);
	root.left = helper(head, middle);
	root.right = helper(middle.next, stopper);
	return root;
}
}