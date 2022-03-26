class Solution {
    final int INF = 100000;
    
    int lowerBound(int[] values, int target) {
        // max i : values[i] <= target
        // [l, r)
        int l = 0, r = values.length;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (values[m] <= target) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }
    
    public int numSquares(int n) {
        int size = 0;
        for (int i = 1; i * i <= n; i++) { size++; }
        
        int[] values = new int[size]; // 1 4 9
        for (int i = 1; i * i <= n; i++) {
            values[i - 1] = i * i;
        }
        
        int dist[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(n);
        
        while (!queue.isEmpty()) {
            int value = queue.pollFirst();
            int index = lowerBound(values, value);
            for (int i = index; i >= 0; i--) {
                if (dist[value - values[i]] == INF) {
                    dist[value - values[i]] = dist[value] + 1;
                    queue.addLast(value - values[i]);
                }
            }
            if (dist[0] != INF) {
                return dist[0];
            }
        }
        return -1;
    }
}