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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // Calls recursive function to determine whether to keep nodes at every point
        // Node is kept if it falls within [low, high] range
        
        // Case where root is null
        if(root == null) return null;
        
        // Case where root value is less than low, everything on the left side as well as root TreeNode can be ignored
        if(root.val < low) return trimBST(root.right, low, high);
        
        // Case where root value is larger than high, everything on the right side as well as root TreeNode can be ignored
        if(root.val > high) return trimBST(root.left, low, high);
        
        // Case where the root TreeNode can be kept, perform recusive function on the left and right branches of root to determine if it should be kept
        root.right = trimBST(root.right, low, high);
        root.left = trimBST(root.left, low, high);
        
        return root;
    }
}