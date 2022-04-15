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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        
        List<List<Integer>>list=new ArrayList<>();
        if(root==null)return list;
        List<Integer>lt=new ArrayList<>();
        
        q.add(root);
        
        while(q.size()>0){
            int siz=q.size();
            for(int i=0;i<siz;i++){
                TreeNode temp=q.remove();
                lt.add(temp.val);
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right); 
            }
            list.add(lt);
            lt=new ArrayList<>();
        }
        return list;
    }
}