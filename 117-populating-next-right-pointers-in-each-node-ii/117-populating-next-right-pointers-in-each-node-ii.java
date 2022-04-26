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
        
        if(root == null)
            return root;
        
        Node head = root;
        
        while(head != null) {
            
            // Dummy node at the left of each level
            Node dummy = new Node();
            
            // Temp node to travers the nodes of one level
            Node temp = dummy;
            
            // Loop in the nodes of one level
            while(head != null) {
                
                // If the left child isn't null then it's the next node
                if(head.left != null) {

                    temp.next = head.left;
                    temp = temp.next;                             
                }
                
                // If the right child isn't null then it's the next node
                if(head.right != null) {

                    temp.next = head.right;
                    temp = temp.next;                             
                }
                
                // Change the current node to the sibling in the right of it
                head = head.next;
            }
            
            // The head of each level is at the right of the dummy node
            head = dummy.next;
        }
        
        return root;
    }
}