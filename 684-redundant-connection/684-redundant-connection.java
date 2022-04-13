class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        for(int i = 1; i <= n; i++) parent[i]=i;
        int[] ans = edges[0];
        
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (!union(a,b,parent,rank)) {
                ans = edge;
            }
        }
        
        return ans;
    }
    private int findParent(int a, int[] parent) {
        if (parent[a] == a) return a;
        parent[a]=findParent(parent[a],parent);
        return parent[a];
    }
    //when true, means a new union resulted
    //when false, means they were already united
    private boolean union(int a, int b, int[] parent, int[] rank) {
        int pa = findParent(a,parent);
        int pb = findParent(b,parent);
        if (pa == pb) return false;
        if (rank[pa] < rank[pb]) parent[pa]=pb;
        else if (rank[pb] < rank[pa]) parent[pb]=pa;
        else {
            parent[pa]=pb;
            rank[pb]++;
        }
        return true;
    }
}