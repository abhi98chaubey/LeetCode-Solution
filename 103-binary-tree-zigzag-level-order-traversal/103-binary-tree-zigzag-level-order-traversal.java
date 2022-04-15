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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res =new ArrayList<>();
    Queue<TreeNode> que= new ArrayDeque<>();
    boolean flag=true;
    if(root==null)
        return res;
    que.add(root);
    while(que.size()>0){
        List<Integer> li = new ArrayList<>();
        int count=que.size();
        for(int i = 0 ; i< count ; i++){
            TreeNode temp = que.remove();
            li.add(temp.val);
            if(temp.left!=null) que.add(temp.left);
            if(temp.right!=null) que.add(temp.right);
            
        }
        if(flag)
            res.add(li);
        else{
            Collections.reverse(li);
            res.add(li);
        }
        flag=!flag;
    }
    return res;
}
}