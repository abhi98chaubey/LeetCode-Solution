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
class CBTInserter {
	LinkedList<TreeNode> que = new LinkedList<>();
	TreeNode headans;
	
    public CBTInserter(TreeNode root) {
    	headans = root;
        que.addLast(root);
        while(true) {
        	TreeNode last = que.get(0);
        	if(last.left == null)
        		break;
        	else
        		que.addLast(last.left);
        	if(last.right == null)
        		break;
        	else {
        		que.addLast(last.right);
        		que.removeFirst();
        	}
        }
    }
    
    public int insert(int val) {
    	TreeNode node = new TreeNode(val);
        TreeNode last = que.get(0);
        que.addLast(node);
        if(last.left == null) {
        	last.left = node;
        }else {
        	last.right = node;
        	que.removeFirst();
        }
    	return last.val;
    }
    
    public TreeNode get_root() {
        return headans;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */