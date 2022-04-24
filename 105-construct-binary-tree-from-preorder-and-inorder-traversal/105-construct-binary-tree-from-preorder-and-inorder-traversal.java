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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode construct(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if(pstart > pend || istart > iend)
            return null;
        
        TreeNode root = new TreeNode(preorder[pstart]);
        int index = istart;
        for(int i=istart; i<=iend; i++) {
            if(inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        
        root.left = construct(preorder, pstart+1, pstart+(index-istart), inorder, istart, index-1);
        root.right = construct(preorder, pstart+(index-istart)+1, pend, inorder, index+1, iend);
        
        return root;
    }
}