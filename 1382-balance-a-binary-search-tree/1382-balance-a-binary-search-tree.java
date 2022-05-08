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
    List<TreeNode> nodes;
    
    public TreeNode balanceBST(TreeNode root) {
        // fill in each level before proceed to next one
        // post order traversal to build the trees 
        nodes = new ArrayList();
        dfsGetList(root);
        return dfs(0, nodes.size()-1);
    }
    
    private void dfsGetList(TreeNode node) {
        if(node == null) return;
        dfsGetList(node.left);
        nodes.add(node);
        dfsGetList(node.right);
    }
    
    private TreeNode dfs(int start, int end) {
        if(start > end) return null;
        
        int mid = start + (end - start)/2;
        TreeNode left = dfs(start, mid-1);
        TreeNode right = dfs(mid+1, end);
        TreeNode cur = nodes.get(mid);
        cur.left = left;
        cur.right = right;
        return cur;
    }
}