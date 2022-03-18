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
    int maxHeightDiff = 0;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        } else {
            findHeight(root, 0);
            return maxHeightDiff <= 1;
        }
    }
    
    private int findHeight(TreeNode root, int h){
        if(root == null){
            return h;
        }
        
        int leftH = findHeight(root.left, h);
        int rightH = findHeight(root.right, h);
        
        maxHeightDiff = Math.max(maxHeightDiff, Math.abs(leftH-rightH));
        
        return Math.max(leftH, rightH) + 1;
    }
}