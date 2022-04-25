/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
   public Node connect(Node root) {
        // We need to know how to connect the nodes, when they have different roots
        // so we can consider the node has three children.
        // traverse pair of nodes (4,5) (5,6) (6,7)
        if (root == null) {
            return null;
        }
        helper(root.left, root.right);
        return root;
    }
    void helper(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return ;
        }
        node1.next = node2;
        helper(node1.left, node1.right);
        // connect two nodes with different root
        helper(node1.right, node2.left);
        helper(node2.left, node2.right);
    }
}