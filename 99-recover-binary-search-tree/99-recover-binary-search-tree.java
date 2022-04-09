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
    public void recoverTree(TreeNode root) {
        TreeNode curr=root;
        TreeNode prev=null;
        TreeNode w1=null;
        TreeNode w2=null;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                if(prev==null)
                    prev=curr;
                else {
                    if(curr.val<=prev.val)
                    {
                        if(w1==null)
                            w1=prev;
                        w2=curr;
                    }
                    prev=curr;
                }
                curr=curr.right;
            }
            else
            {
                TreeNode pred=curr.left;
                while(pred.right!=null && pred.right!=curr)
                {
                    pred=pred.right;
                }
                if(pred.right==null)
                {
                    pred.right=curr;
                    curr=curr.left;
                }
                else
                {
                    pred.right=null;
                    if(prev==null)
                    prev=curr;
                    else {
                        if(curr.val<=prev.val)
                        {
                            if(w1==null)
                                w1=prev;
                            w2=curr;
                        }
                        prev=curr;
                    }
                    curr=curr.right;
                }
            }
        }
        if(w1==null && w2==null)
            return;
        int temp=w1.val;
        w1.val=w2.val;
        w2.val=temp;
    }
}