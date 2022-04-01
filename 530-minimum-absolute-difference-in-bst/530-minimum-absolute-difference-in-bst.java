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
    
    List<Integer> elements = new ArrayList<>();
    
    public int getMinimumDifference(TreeNode root) {
        
        traverse(root);
        
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i < elements.size() - 1; ++i) {
            
            int diff = Math.abs(elements.get(i) - elements.get(i + 1));
            
            if (diff < minDiff) {
                minDiff = diff;
            }
            
        }
        
        return minDiff;
        
    }
    
    private void traverse(TreeNode node) {
        
        if (node == null) {
            return;
        }

        traverse(node.left);
        
        elements.add(node.val);
        
        traverse(node.right);        
    }
}