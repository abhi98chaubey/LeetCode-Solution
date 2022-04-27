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
  public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        
        List<Integer> result = new ArrayList();
        
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> temp = new ArrayList();
            for(int i=0; i<n; i++){
                TreeNode tn = q.poll(); 
                if(i == 0) result.add(tn.val);
                if(tn.right != null) q.offer(tn.right);
                if(tn.left != null) q.offer(tn.left);
            }
        }
        return result;
    }
}