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
       public int averageOfSubtree(TreeNode root) {
        return helper(root)[2];
    }
    
    int[] helper(TreeNode n) {
        if (n == null) {
            return new int[] {0,0,0};
        }
        //count starts with 1 for current node itself, sum starts with current node's value
        int count = 1, sum = n.val, res = 0;
        if (n.left != null) {
            int[] l = helper(n.left);
            count += l[0];
            sum += l[1];
            res+= l[2];
        }
        if (n.right != null) {
            int[] r = helper(n.right);
            count += r[0];
            sum += r[1];
            res += r[2];
        }
		//check if current node is equal to average
        if (n.val == sum / count) {
            res++;
        }
        return new int[] {count, sum, res};
    }
}