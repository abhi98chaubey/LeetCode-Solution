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
class Solution 
{
    public TreeNode bstFromPreorder(int[] preorder) 
    {
          return helper(preorder , 0 , preorder.length-1);
    }
    private TreeNode helper(int[] preorder , int start , int end)
    {
        if(start>end)
            return null;
        TreeNode root= new TreeNode(preorder[start]);
        int i=start;
        while(true)
        {
            if(i<preorder.length && preorder[i]>preorder[start]) 
            {
                i=i-1;
                break;
            }
            if(i==end)
                break;
            i++;
        }
        //now i points to the end of what should be in left sub tree
        root.left=helper(preorder , start+1 , i);
        root.right = helper(preorder , i+1 , end);
        return root;
    }
}