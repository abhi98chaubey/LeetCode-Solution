class Solution {
public int numOfMinutes(int n, int head, int[] arr, int[] informTime) {

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
    
    for(int i=0;i<n;i++)
        adj.add(new ArrayList());
    
    for(int i=0;i<n;i++){
        if(arr[i]!=-1){
            ArrayList<Integer> mgr = adj.get(arr[i]);
            mgr.add(i);
        }
    }
    
    
    return dfs(adj, head, informTime, 0);
    
}


int dfs(ArrayList<ArrayList<Integer>> adj, int ind, int[] informTime, int time){
    
    
    ArrayList<Integer> childs = adj.get(ind);
    
    int max = time;
    
    for(int child : childs){
        max = Math.max(max, dfs(adj, child, informTime, time+informTime[ind]));
    }
    
    return max;
}
}