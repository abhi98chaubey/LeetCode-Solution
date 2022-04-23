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
    int sum = 0;
    private void solution(TreeNode root, int path){
        if(root.left == null && root.right == null){
            sum += (path*10)+root.val;
            return;
        }
        path = (path*10)+root.val;
        if(root.left != null)
            solution(root.left, path);
        
        if(root.right != null)
            solution(root.right, path);
    }
    public int sumNumbers(TreeNode root) {
        solution(root, 0); 
        return sum;
    }
}