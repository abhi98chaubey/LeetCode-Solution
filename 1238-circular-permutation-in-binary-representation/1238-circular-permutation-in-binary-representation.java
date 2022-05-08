class Solution {
    List<Integer> op = new ArrayList();
    HashSet<Integer> visited = new HashSet();
    public List<Integer> circularPermutation(int n, int start) {
        op.add(start);
        visited.add(start);
        
        recursion(start, n);
        return op;
    }
    
    private void recursion(int start, int n) {
        for (int i = 0; i < n; i++) {
            int next = start ^ (1 << i);
            if (!visited.contains(next)) {
                op.add(next);
                visited.add(next);
                recursion(next, n);
            }
        }
    }
}