class Solution {
    class Node implements Comparable<Node> {
        private int prev;
        private int val;
        private int cumCost;
        
        private Node (int prev, int val, int cumCost) {
            this.prev = prev;
            this.val = val;
            this.cumCost = cumCost;
        }
        
        @Override
        public int compareTo(Node node) {
            if (node == null) {
                return 1;
            }
            return Integer.compare(this.cumCost, node.cumCost);
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        //ask corner case: can arrays be null? can k be out of bounds? etc.
        
        //general thoughts: BFS, however, we need something to store the state at each node (lowest cost), this brings us to Dijkstra's algorithm
        
        //First, get our adjacency lists ready
        //it would be in the form of from: List of [to, weight]
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        //initialize
        //Time O(V) Vertices
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        //populate
        //Time O(E) Edges
        for (int[] relationship : times) {
            int from = relationship[0];
            int to = relationship[1];
            int weight = relationship[2];
            
            adjList.get(from).add(new int[]{to, weight});
        }
        
        //Now to do Dijkstra's algorithm, we need the followings storagse
        //Min Heap to store nodes to be processed
        //A map to store the lowest cost for all nodes
        //A map to store the best route prior node for all nodes (optional for this question, but just to demonstrate you can get this list)
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Integer[] lowestCost = new Integer[n + 1];
        Integer[] priorNode = new Integer[n + 1];
        
        //initialize all the data structures for k
        pq.offer(new Node(-1, k, 0)); //-1 means no previous node
        lowestCost[k] = 0;
        priorNode[k] = null; //it is already null but trying to be explicit here
        
        //Now run our BFS / Dijkstra
        //Time O(VlogE + ElogE) Vertices and Edges
        while (!pq.isEmpty()) {
            //process the current node
            Node cur = pq.poll();
            int from = cur.prev;
            int to = cur.val;
            int cumCost = cur.cumCost;
            
            //record our state
            if (lowestCost[to] == null) {
                lowestCost[to] = cumCost;
                priorNode[to] = from;
            } else {
                if (cumCost < lowestCost[to]) {
                    lowestCost[to] = cumCost;
                    priorNode[to] = from;
                }
            }
            
            //check neighbors using adjacency list
            for (int[] neighbor : adjList.get(to)) {
                int newFrom = to;
                int newTo = neighbor[0];
                int weight = neighbor[1];
                
                int newCost = cumCost + weight;
                
                if (lowestCost[newTo] == null) {
                    pq.offer(new Node(newFrom, newTo, newCost));
                }
            }
        }
        
        //finally, we just need to check the max number in lowestCost array if it does not contain null (meaning the node is unreachable)
        int result = Integer.MIN_VALUE;
        //Time O(V) Vertices
        for (int i = 1; i < lowestCost.length; i++) {//Note that i = 0 is invalid because we do not have 0th node so we start from 1
            Integer x = lowestCost[i];
            if (x == null) {
                return -1;
            }
            
            result = Math.max(result, x);
        }
        
        return result;
    }
}