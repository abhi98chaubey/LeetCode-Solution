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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        preOrder(root, "", list);
        return list; 
    }
    
    public void preOrder(TreeNode root, String s, List<String> list){
        if(root == null) return;
        s = s + String.valueOf(root.val);
        if(root.left == null && root.right == null) {
            list.add(s);
            return ;
        }
        if(root.left != null) preOrder(root.left,s+"->", list);
        if(root.right != null) preOrder(root.right,s+"->", list);
    }
}