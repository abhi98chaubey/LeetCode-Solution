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
    
    List<List<Integer>> paths = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if(root == null)
            return paths;
        
        dfs(root, targetSum, new ArrayList<>());
        
        return paths;
    }
    
    void dfs(TreeNode node, int targetSum, ArrayList<Integer> path) {
        
        // 1- Check specific case
        if(node == null)
            return;
        
        // 2- Prosses a cell
            path.add(node.val);
            targetSum -= node.val;
        
        if(targetSum == 0 && node.left == null && node.right == null)
            paths.add(path);
        
        
        // 3- Call dfs as many times as nedded
        dfs(node.left, targetSum, new ArrayList<>(path));
        dfs(node.right, targetSum, new ArrayList<>(path));
    }
}