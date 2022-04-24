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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Trivial case: empty tree
        if (root == null) return Collections.EMPTY_LIST;
        
        // BFS
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Deque<TreeNode> level, next, temp;
        level = new ArrayDeque<TreeNode>();
        next = new ArrayDeque<TreeNode>();
        List<Integer> list;
        TreeNode node;
        level.add(root);
        while (!level.isEmpty()) {
            // For each node on the current level:
            // 1. Add the value to the answer list for this level.
            // 2. Add the child nodes to the next level.
            list = new ArrayList<Integer>();
            while (!level.isEmpty()) {
                node = level.poll();
                list.add(node.val);
                if (node.left != null) next.addLast(node.left);
                if (node.right != null) next.addLast(node.right);
            }
            answer.add(list);
            
            // Current level is now empty.  Swap with the next level.
            temp = level;
            level = next;
            next = temp;
        }
        
        // Levels are now in top-to-bottom order.  Reverse that order, and return.
        Collections.reverse(answer);
        return answer;
    }
}