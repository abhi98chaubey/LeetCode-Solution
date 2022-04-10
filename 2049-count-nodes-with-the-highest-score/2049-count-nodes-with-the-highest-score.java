class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    int leftChilds=0;
    int rightChilds=0;
    TreeNode(int val)
    {
        this.val=val;
    }
}
class Solution {
    HashMap<Long,Integer> costs;
    long max; //To store maximum cost value
    int n;
    public int countHighestScoreNodes(int[] parents) {
        costs=new HashMap<Long,Integer>(); //To store frequency of each cost value
        max=0;
        n=parents.length;
        HashMap<Integer,TreeNode> hm=new HashMap<Integer,TreeNode>();
        TreeNode root=new TreeNode(0); //Initializing root node
        hm.put(0,root);
        for(int i=1;i<parents.length;i++)
        {
            int parent=parents[i];
            TreeNode child=hm.getOrDefault(i,new TreeNode(i));
            TreeNode parentNode=hm.getOrDefault(parent,new TreeNode(parent));
            if(parentNode.left==null)
            {
                parentNode.left=child;
            }
            else
            {
                parentNode.right=child;
            }
            hm.put(i,child);
            hm.put(parent,parentNode);
        }//Loop to construct tree structure.
        postOrderTraverse(root);  //postOrder traversal
        return costs.get(max); // Returning maximum frequency
    }
    public int postOrderTraverse(TreeNode root)
    {
        if(root==null)
            return 0;
       
        long one=1; 
        root.leftChilds=postOrderTraverse(root.left);  //Getting no of leftChilds
        root.rightChilds=postOrderTraverse(root.right); //Getting no of rightChilds
        long score=(one*Math.max(root.leftChilds,1)*(Math.max(root.rightChilds,1))*(Math.max(n-root.leftChilds-root.rightChilds-1,1))); // Calculating the score of the node
        costs.put(score,costs.getOrDefault(score,0)+1);
        max=Math.max(score,max);
        return root.leftChilds+root.rightChilds+1; 
    }
}