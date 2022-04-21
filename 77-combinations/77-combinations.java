class Solution {
   private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    public void backtrack(int start, int n, int k) {
        if (k == path.size()) {
            res.add(new LinkedList<>(path));
        }
        for (int i = start ; i <= n; i++) {
            path.addLast(i);
            backtrack(i + 1, n, k);
            path.removeLast();
        }
    }
}