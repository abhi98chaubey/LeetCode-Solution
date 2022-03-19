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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        return getMinDepth(root, 1);
    }
    
    private int getMinDepth(TreeNode root, int depth){
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            return depth;
        }
        
        int leftMinD = getMinDepth(root.left, depth+1);
        int rightMinD = getMinDepth(root.right, depth+1);
        
        if(leftMinD == 0 || rightMinD == 0){
            return Math.max(leftMinD, rightMinD);
        }
        return Math.min(leftMinD, rightMinD);
    }
}