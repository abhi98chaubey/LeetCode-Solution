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
    public int pathSum(TreeNode root, int targetSum) {
    List<Integer> currentPath = new LinkedList<>();
    return countPaths(root, targetSum, currentPath);
  }

  private int countPaths(TreeNode currentNode, int targetSum, List<Integer> currentPath) {
    if (currentNode == null)
      return 0;
    // add the current node to the path
    currentPath.add(currentNode.val);
    int pathCount = 0, pathSum = 0;
    // find the sums of all sub-paths in the current path list
    ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
    while (pathIterator.hasPrevious()) {
      pathSum += pathIterator.previous();
      // if the sum of any sub-path is equal to 'S' we increment our path count.
      if (pathSum == targetSum) {
        pathCount++;
      }
    }
    // traverse the left sub-tree
    pathCount += countPaths(currentNode.left, targetSum, currentPath);
    // traverse the right sub-tree
    pathCount += countPaths(currentNode.right, targetSum, currentPath);

    // remove the current node from the path to backtrack, 
    // we need to remove the current node while we are going up the recursive call stack.
    currentPath.remove(currentPath.size() - 1);

    return pathCount;
  }
}