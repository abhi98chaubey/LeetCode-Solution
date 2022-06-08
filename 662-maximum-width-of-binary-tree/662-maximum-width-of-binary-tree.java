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
class Pair{
    TreeNode node;
    int index;
    Pair(){};
    Pair(TreeNode node,int index){
        this.node=node;
        this.index=index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue =new LinkedList<Pair>();
        queue.offer(new Pair(root,0));
        int max=0;
        while(!queue.isEmpty()){
            int levelNum =queue.size();
            int min = queue.peek().index;
            int first=0;
            int last=0;
            int sum=0;
            for(int i=0;i<levelNum;i++){
                Pair cur = queue.poll();
                TreeNode curnode = cur.node;
                int curindex=cur.index-min;
                if(i==0){first=curindex;}//imp
                if(i==levelNum-1){last =curindex;}//imp
                if(curnode.left != null){
                    queue.offer(new Pair(curnode.left,((2*curindex) + 1)));
                }
                if(curnode.right !=null){
                    queue.offer(new Pair(curnode.right,(2*curindex)+2));
                }
                sum = (last-first)+1;
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}