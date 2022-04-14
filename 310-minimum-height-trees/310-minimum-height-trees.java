class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res= new ArrayList<Integer>();
        if( n==1){
           res.add(0);
            return res; }
         HashMap<Integer, List<Integer>> map= new HashMap();
        int[] rank= new int[n];
        for( int i=0;i<n;i++)
            map.putIfAbsent(i, new ArrayList<>());
        for( int[] e: edges)
        {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            rank[e[0]]++;
            rank[e[1]]++;
        }
        Queue<Integer> q= new LinkedList();
        for( int i=0;i<n;i++)
          if(rank[i]==1) q.add(i);
        while(n>2)
        {
           int size=q.size();
            n-=size;
            for( int i=0;i<size;i++)
            {
              int node=q.poll();
                for( int j: map.get(node))
                {rank[j]--;
                    if(rank[j]==1)
                        q.add(j);
                } }}
              res.addAll(q);
             return res; 
        }
    }