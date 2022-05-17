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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treeMap = new TreeMap<>();
        inOrder(root,treeMap, 0,0);
        
        for(TreeMap<Integer, PriorityQueue<Integer>> ys: treeMap.values()){
            ans.add(new ArrayList<>());
            
            for(PriorityQueue<Integer> nodes: ys.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
        return ans;
    }
    
    
    private void inOrder(TreeNode root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treeMap, int vl, int tl){
        if(root == null){
            return;
        }
        if(!treeMap.containsKey(vl)){
            treeMap.put(vl, new TreeMap<>());
        }
        
        if(!treeMap.get(vl).containsKey(tl)){
            treeMap.get(vl).put(tl, new PriorityQueue<>());
        }
        treeMap.get(vl).get(tl).offer(root.val);
       
        
        // left call
        inOrder(root.left, treeMap,vl-1,tl+1);
    
        // right call    
        inOrder(root.right, treeMap,vl+1,tl+1);

    }
}